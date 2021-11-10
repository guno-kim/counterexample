import React,{useState,useEffect} from 'react'
import InputBlock from './InputBlock'
import {Button} from 'antd'

function InputBlockContainer(props) {
    const makeEmptyArray=()=>{
        let result=[]
        for(let j=0;j<10;j++){
            let temp=[]
            for(let i=0;i<10;i++){
                temp.push("")
            }   
            result.push(temp)
        }
        return result
    }

    const [Blocks, setBlocks] = useState(props.default)

    useEffect(() => {
        props.sendState(Blocks)
    }, [])

    useEffect(() => {
        props.sendState(Blocks)
    }, [Blocks])

    const changeInputBoxs=(index)=>{
        return(
            (box)=>{
                let temp=Blocks
                temp[index]=box
                setBlocks(temp)
            }
        )
    }
    const deleteInputBox=(index)=>{
        let temp=[...Blocks]
        temp.splice(index,1)
        setBlocks(temp)
    }


    const renderBoxs=Blocks.map((block,index)=>{
        if(!block.content){
            return
        }
        return(
            <div key={index}  style={{display:'flex',alignItems:'center',marginTop:'10px', width:'100%'}}>
                <InputBlock data={block} sendState={changeInputBoxs(index)}/>
                <Button onClick={()=>deleteInputBox(index)} type="primary" style={{marginLeft:'20px'}} danger>삭제</Button>
            </div>
        )
    })

    const addInputBlocks=()=>{
        let temp=[...Blocks,{content:makeEmptyArray(),width:1,height:1,horizonRep:1,verticalRep:1}]
        setBlocks(temp)
    }

    
    return (
        <div style={{textAlign:'center', width:'100%'}}>
            {renderBoxs}
            <Button onClick={addInputBlocks} style={{margin:'5px'}}>추가</Button>
        </div>
    )
}

export default InputBlockContainer
