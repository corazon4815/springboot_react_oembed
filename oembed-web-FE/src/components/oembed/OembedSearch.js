import React, { useState } from "react";

import { Button, Grid, TextField } from "@mui/material";

const OembedSearch = (props) => {
    // 사용자의 입력을 저정할 오브젝트
    const [url, setUrl] = useState("");

    // onButtonClick 함수 작성
    const onButtonClick = () => {
        props.setUrl(url);
    };

    // onInputChange 함수 작성
    const onInputChange = (e) => {
        setUrl(e.target.value);
    };

    // enterKeyEventHandler 함수
    const enterKeyEventHandler = (e) => {
        if (e.key === 'Enter') {
            onButtonClick();
        }
    };

    return (
        <Grid container style={{ marginTop: 20 }}>
            <Grid xs={11} md={11} item style={{ paddingRight: 16 }}>
                <TextField placeholder="Search for url" fullWidth
                           onChange={onInputChange}
                           onKeyPress={enterKeyEventHandler}
                           value={url}/>
            </Grid>
            <Grid xs={1} md={1} item >
                <Button fullWidth style={{ height: '100%' }} color="secondary" variant="outlined"
                        onClick={onButtonClick}>
                    search
                </Button>
            </Grid>
        </Grid>
    );
}

export default OembedSearch;
