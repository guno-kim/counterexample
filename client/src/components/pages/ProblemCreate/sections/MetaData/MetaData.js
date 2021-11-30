import React,{useContext} from 'react'
import './style.scss'
import {Input} from 'antd'
import { ProblemContext } from '../../../../../context/problem'

function MetaData(props) {
    const {id,title,desc,handleId,handleTitle,handleDesc } = useContext(ProblemContext);


    return (
        <div className="meta">
            <div className="meta-container">
                <div className="meta-name">문제 번호</div>
                <Input className="meta-id" value={id} onChange={handleId}></Input>
            </div>
            <div className="meta-container">
                <div className="meta-name">문제 제목</div>
                <Input className="meta-title" value={title} onChange={handleTitle}></Input>
            </div>
            <div className="meta-container">
                <div className="meta-name">문제 설명</div>
                <Input className="meta-desc" value={desc} onChange={handleDesc}></Input>
            </div>
        </div>
    )
}

export default MetaData
