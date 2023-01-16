import * as React from 'react';
import {
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import {useCallback, useEffect, useState} from "react";

export default function OembedTable(props) {
    const {data} = props;
    const [rows, setRows] = useState([]);

    useEffect(() => {
        if (data !== null) {
            initData();
        }
    }, [data]);

    const createData = (name, contents) => {
        return {name, contents};
    }

    const initData = useCallback(() => {
        let temp = [];
        Object.entries(data).map(([key, value]) =>
            temp.push(createData(key, value))
        )
        setRows(temp);
    }, [rows, data])

    return (
        <TableContainer component={Paper}>
            <Table sx={{minWidth: 650}} size="small" aria-label="a dense table">
                <TableHead>
                    <TableRow>
                        <TableCell align="center" width={"20%"}>항목</TableCell>
                        <TableCell align="center" width={"80%"}>내용</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.length > 0 && rows.map((row, idx) => (
                        <TableRow
                            key={idx}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell align="center" width={"20%"} component="th" scope="row">
                                {row.name}
                            </TableCell>
                            {(() => {
                                switch (row.name) {
                                    case "thumbnailUrl":
                                    case "thumbnailUrlWithPlayButton":
                                        return (
                                            <TableCell align="center" width={"70%"}><img style={{"width": "60%"}}
                                                                                         src={row.contents && row.contents}/></TableCell>
                                        )
                                    case "html":
                                        return (
                                            <TableCell align="center" width={"70%"}>
                                                <div dangerouslySetInnerHTML={{__html: row.contents && row.contents}}/>
                                            </TableCell>
                                        )
                                    case "url":
                                    case "authorUrl":
                                    case "providerUrl":
                                        return (
                                            <TableCell align="center" width={"70%"}>
                                                <div
                                                    dangerouslySetInnerHTML={{__html: `<a href="${row.contents && row.contents}">${row.contents && row.contents}</a>`}}/>
                                            </TableCell>
                                        )
                                    default :
                                        return (
                                            <TableCell tag='a' align="center" width={"70%"}>{row.contents}</TableCell>
                                        )
                                }
                            })()
                            }
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}