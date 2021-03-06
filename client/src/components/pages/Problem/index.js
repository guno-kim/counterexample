import React,{useEffect,useState,useRef} from 'react'
import styled from 'styled-components'
import { useSelector } from 'react-redux'
import problemAPI from '../../../apis/problem'
import inputAPI from '../../../apis/input'

import { UpOutlined,DownOutlined } from '@ant-design/icons';
import Layout from '../../Layout/Layout2'
import {Button,Collapse,Divider } from 'antd'
import { useHistory } from 'react-router-dom'
import VariableContainer from './sections/Variable/VariableContainer'
import InputBlockContainer from './sections/InputBlockContainer/InputBlocks'
import InputFormat from './sections/InputFormat/InputFormat'
import CodeBox from  './sections/CodeBox/CodeBox'
import CodeBox2 from  '../../commons/CodeBox/CodeBox'


const { Panel } = Collapse;
function Problem(props) {
    const problem_Id=props.match.params.problem_Id
    const [Setting, setSetting] = useState({})
    const [Format, setFormat] = useState([])
    const [Data, setData] = useState([])
    const [MyCode, setMyCode] = useState({language:'python',code:''})
    const [Like, setLike] = useState("");

    let userId = useSelector(state => state.user.data&&state.user.data._id)
    const textAreaRef = useRef(null);
    const handleMyCode=(code)=>{
        setMyCode(code)
    }
    useEffect(async () => {
        const request=await problemAPI.get({
            params:{
                _id:problem_Id
            }
        })
        setSetting(request.data)
    }, [])
    useEffect(() => {
       if(!Setting.id){
           return
       }
        if(Setting.like.includes(userId)){
            setLike("like")
        }else if(Setting.dislike.includes(userId)){
            setLike('dislike')
        }else{
        setLike('null')
    }
    }, [userId,Setting])
   const history=useHistory()

   const getExample=()=>{
    let body={
        params:{
            setting:{
                variables:Setting.variables,
                inputBlocks:Setting.inputBlocks
            }
        }
    }
    inputAPI.getExample(body)
        .then((res)=>{
            if(res.status==201){
                alert(res.data.error)
            }else if(res.status==200){
                setFormat(res.data.format)
                setData(res.data.input)
            }
        })
    }
    function copyToClipboard(e) {
        textAreaRef.current.select();//????????? ??????
        document.execCommand('copy');//??????
        e.target.focus();//?????? ??????
    };
    function handleLike(){
        problemAPI.like(problem_Id)
            .then(async()=>{
                const request=await problemAPI.get({
                    params:{
                        _id:problem_Id
                    }
                })
                setSetting(request.data)
            })
    }
    function handleDislike(){
        problemAPI.dislike(problem_Id)
            .then(async()=>{
                const request=await problemAPI.get({
                    params:{
                        _id:problem_Id
                    }
                })
                setSetting(request.data)
            })
    }
    return (
        <Layout>
            <Wrapper>
                <h2 style={{margin:'50px 0', fontSize:'30px'}}>[{Setting.id}] {Setting.title}</h2>
                <div style={{marginBottom:'30px'}}>{Setting.description}</div>
                
                <Collapse defaultActiveKey={[]} style={{width:'900px'}}>
                    <Panel header="????????? ??????" key="1" style={{fontSize:'18px'}}>
                        <Divider style={{margin:'50px 0' ,fontSize:'20px'}}>??????</Divider>
                        <VariableContainer variables={Setting.variables}/>
                        <Divider style={{margin:'50px 0',fontSize:'20px'}}>????????? ??????</Divider>
                        <InputBlockContainer default={Setting.inputBlocks}/>
                    </Panel>
                    <Panel header="????????? ??????" key="2" style={{fontSize:'18px'}}>
                    <div className='content-container'>
                    <div style={{display:'flex'}}>
                        <div style={{margin:'20px'}}>
                            <div style={{fontSize:'2rem', textAlign:'center'}}>?????? ??????</div>
                            <InputFormat format={Format}/>
                        </div>

                        <div style={{margin:'20px'}}>
                            <div style={{display:'flex',alignItems:'center',justifyContent:'center', position:'relative'}}>
                                <div style={{fontSize:'2rem', margin:'0 20px'}}>?????????</div>
                                <button onClick={copyToClipboard} id='copy-button' >??????</button> 
                            </div>
                            
                            <textarea 
                                ref={textAreaRef}
                                value={Data}
                                id='output'
                            />
                        </div>
                    </div>
                    <Button onClick={getExample} size='medium' >??????</Button>
                    </div>
                    </Panel>
                    <Panel header="?????? ??????" key="3" style={{fontSize:'18px'}} forceRender={true}>
                        <CodeBox value={Setting.testCode}/>
                    </Panel>
                </Collapse>
                <div className="content-container" style={{marginTop:'40px'}}>
                    <div className='header'>
                        <h1 className='title'>????????? ?????? ??????</h1>
                        <h3 className='description'>???????????? ????????? ???????????????</h3>
                    </div>
                    <CodeBox2 value={MyCode} sendState={handleMyCode} />
                </div>

                <Button onClick={()=>{
                    history.push({
                        pathname:`/problem/${problem_Id}/test`,
                        state:{setting:{...Setting,myCode:MyCode}}
                })}}
                style={{width:'100px', height:'40px',margin:'10px'}}
                type={'primary'}
                size={'large'}
                >?????????</Button>

                <div>
                    <Button style={{width:'60px',height:'60px',margin:'10px'}}
                        onClick={handleLike}
                        className={
                                Like=='like'? 'active':''
                        }
                    >
                        <UpOutlined />
                    </Button>
                    <Button style={{width:'60px',height:'60px',margin:'10px'}}
                        onClick={handleDislike}
                        className={
                            Like=='dislike'? 'active':''
                    }
                    >
                        <DownOutlined />
                    </Button>
                </div>
            </Wrapper>
        </Layout>
    )
}

const Wrapper=styled.div`
display:flex ;
flex-direction: column;
align-items: center;
text-align: center;
width: 60%;
height:100%;
#output{
    border: 1px solid black;
    width: 400px;
    height: 400px;
    font-size: 20px;
    overflow-y: scroll auto;
    overflow-x: scroll auto;
    border-radius: 10px;
    white-space:nowrap;
}
.active{
    background-color: skyblue;
}
`

export default Problem
