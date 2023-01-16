import React, {useState, useEffect, useCallback} from "react";
import {
    Container,
    Paper,
    Grid,
    AppBar,
    Toolbar,
    Typography,
} from "@mui/material";
import OembedSearch from "./components/oembed/OembedSearch";
import OembedTable from "./components/oembed/OembedTable";

function App() {
    const [url, setUrl] = useState("");
    const [data, setData] = useState(null);

    useEffect(() => {
        if (url !== "") {
            searchOembed();
        }
    }, [url]);

    const searchOembed = useCallback(() => {
        reqGetOembed(url);
    }, [url]);

    const reqGetOembed = useCallback((url) => {
        fetch('/api/oembed?url=' + url)
            .then(response => response.text())
            .then(message => {
                console.log('message', message)
                let result = JSON.parse(message);
                console.log('result', result)
                if (result.data) {
                    setData(result.data);
                } else {
                    alert("No Results Found");
                    return false;
                }
            });
    }, [])

    return (
        <React.Fragment>
            <AppBar position="static">
                <Toolbar>
                    <Grid justifyContent="space-between" container>
                        <Grid item>
                            <Typography variant="h6">Oembed Test</Typography>
                        </Grid>
                    </Grid>
                </Toolbar>
            </AppBar>
            <Container maxWidth="md">
                <OembedSearch setUrl={setUrl}/>
                {
                    data !== null ?
                        <div className="oembed-list">
                            <Paper style={{margin: 16}}>
                                <OembedTable data={data}/>
                            </Paper>
                        </div>
                        :
                        null
                }
            </Container>
        </React.Fragment>
    );
}

export default React.memo(App);