import React,{useState,useContext,useRef} from 'react'
import {Button,Input,Form,Modal} from 'antd'
import styled from 'styled-components'
import Layout from '../../Layout/Layout'
import { withRouter } from 'react-router-dom';
import problemAPI from '../../../apis/problem'
import inputAPI from '../../../apis/input'
import {ProblemContext} from '../../../context/problem'

import _Int from './sections/Variable/_Int'
import _Float from './sections/Variable/_Float'
import _String  from './sections/Variable/_String'
import VariableContainer from './sections/Variable/VariableContainer';
import InputFormat from './sections/InputFormat/InputFormat'
import CodeBox from '../../commons/CodeBox/CodeBox'
import ContentContainer from './sections/ContentContainer/ContentContainer';
import MetaData from './sections/MetaData/MetaData';
import Blocks from './sections/Blocks/Blocks'

function GenerateData(props) {
    const { title,id,blocks,desc} = useContext(ProblemContext);

    const [Format, setFormat] = useState([])
    const [Data, setData] = useState([])
    const [Variables, setVariables] = useState([{type:'int',name:'a',min:0,max:5,fix:true}])
    const [AnswerCode, setAnswerCode] = useState({language:'python',code:''})
    
    const textAreaRef = useRef(null);

    //State Handle Function
    const handleVariables=(variables)=>{setVariables(variables)}
    const handleAnswerCode=(code)=>{setAnswerCode(code)}
    const handleSave=()=>{
        problemAPI.create({
            problemNum:id,
            title,blocks,desc,
            answerCode:AnswerCode
        })
            .then((res)=>{
                    alert("저장 성공")
                    console.log(props)
                    // props.history.push('/problem')
            })
            .catch((err)=>{
                console.log(err)
                alert("저장 실패")
            })
    }

    const getExample=()=>{
        let body={
            params:{
                setting:{
                    variables:Variables,
                    inputBlocks:Blocks
                }
            }
        }
        inputAPI.getExample(body)
            .then((res)=>{
                if(res.status==201){
                    alert(res.data.error)
                    console.log(res.data)
                }else if(res.status==200){
                    setFormat(res.data.format)
                    setData(res.data.input)
                }
            })
    }
    function copyToClipboard(e) {
        textAreaRef.current.select();//텍스트 선택
        document.execCommand('copy');//복사
        e.target.focus();//선택 해제
    };
  
   
    return (
        <Layout>
        <Wrapper>
            <ContentContainer title={"문제 정보"} subtitle={"사용할 변수를 선언하세요"} content={
                <MetaData />
            }/>
            <ContentContainer title={"변수 선언"} subtitle={"사용할 변수를 선언하세요"} content={
                <VariableContainer sendState={handleVariables} default={Variables}/>
            }/>
            <ContentContainer title={"입력 데이터 만들기"} subtitle={"변수와 숫자를 이용해 입력 데이터를 만드세요"} content={
                <Blocks />
            }/>

            <div className='content-container'>
                <div style={{display:'flex'}}>
                    <div style={{margin:'20px'}}>
                        <div style={{fontSize:'2rem', textAlign:'center'}}>입력 형식</div>
                        <InputFormat format={Format}/>
                    </div>

                    <div style={{margin:'20px'}}>
                        <div style={{display:'flex',alignItems:'center',justifyContent:'center', position:'relative'}}>
                            <div style={{fontSize:'2rem', margin:'0 20px'}}>입력값</div>
                            <button onClick={copyToClipboard} id='copy-button' >복사</button> 
                        </div>
                        
                        <textarea 
                            ref={textAreaRef}
                            value={Data}
                            id='example'
                        />
                    </div>
                </div>
                <Button onClick={getExample} size='medium' >생성</Button>
            </div>

            <ContentContainer title={"정답 코드 입력"} subtitle={"비교에 사용될 정답 코드를 입력하세요"} content={
                <CodeBox value={AnswerCode} sendState={handleAnswerCode} style={{height:'400px'}}/>
            }/>
                
            <Button type="primary"  size='large' onClick={handleSave} style={{marginBottom:'50px'}}>저장</Button>
                
        </Wrapper>

        </Layout>
    )
}

const Wrapper=styled.div`
    display:flex ;
    flex-direction:column;
    justify-content: center;
    align-items: center;
    width: 90%;
    min-width:1000px;

        
    #example{
        border: 1px solid black;
        width: 400px;
        height: 400px;
        font-size: 20px;
        overflow-y: scroll auto;
        overflow-x: scroll auto;
        border-radius: 10px;
        white-space:nowrap;
    }
    #copy-button{
        background:white;
        outline:none;
        border:1px solid gray;
    }
    #copy-button:hover{
        cursor: pointer;
    }
`



export default withRouter(GenerateData)
