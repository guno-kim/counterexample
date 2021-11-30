import React,{useState,useEffect,useContext} from 'react'
import Block from './Block'
import {Button} from 'antd'
import { ProblemContext } from '../../../../../context/problem'

function Blocks() {
    const {blocks,handleBlocks} = useContext(ProblemContext);
    const [Blocks, setBlocks] = useState(blocks);
    useEffect(() => {
        setBlocks(blocks)
    }, [blocks])

    useEffect(() => {
        handleBlocks(Blocks)
    }, [Blocks])

    const deleteInputBox=(index)=>{
        let temp=[...blocks]
        temp.splice(index,1)
        setBlocks(temp)
    }


    const renderBoxs=Blocks.map((block,index)=>{
        return(
            <div key={index}  style={{display:'flex',alignItems:'center',marginTop:'10px', width:'100%'}}>
                <Block index={index} block={blocks[index]}/>
                <Button onClick={()=>deleteInputBox(index)} type="primary" style={{marginLeft:'20px'}} danger>삭제</Button>
            </div>
        )
    })

    const addInputBlocks=()=>{
        let temp=[...Blocks,{content:[[""]],width:1,height:1,horizonRep:1,verticalRep:1}]
        setBlocks(temp)
    }

    
    return (
        <div style={{textAlign:'center', width:'100%'}}>
            {renderBoxs}
            <Button onClick={addInputBlocks} style={{margin:'5px'}}>추가</Button>
        </div>
    )
}

export default Blocks
