import React,{useState,useEffect,useContext} from 'react'
import {Input, InputNumber} from 'antd'
import "./style.scss"
import { ProblemContext } from '../../../../../context/problem'


function InputBlock(props) {
    const index=props.index
    const {handleBlock} = useContext(ProblemContext);

    const [Block, setBlock] = useState(props.block)
    useEffect(() => {
        setBlock(props.block)
    }, [props.block])
    useEffect(() => {
        handleBlock(index,Block)
    }, [Block])

    const handleWidth=(e)=>{
        setBlock({...Block,width:e,content:getNewContent(Block.height,e)})
    }
    const handleHeight=(e)=>{
        setBlock({...Block,height:e,content:getNewContent(e,Block.width)})
    }
    const handleHorizonRep=(e)=>{
        setBlock({...Block,horizonRep:e.target.value})
    }
    const handelVerticalRep=(e)=>{
        setBlock({...Block,verticalRep:e.target.value})
    }
    const handleInputs=(y,x,e)=>{
        let temp=Block.content
        temp[y][x]=e.target.value
        setBlock({...Block,content:temp})
    }

    const getNewContent=(h,w)=>{
        let temp = new Array(h).fill("").map(()=>new Array(w).fill(""))
        for(let i=0;i<Math.min(h,Block.height);i++){
            for(let j=0;j<Math.min(w,Block.width);j++){
                temp[i][j]=Block.content[i][j]
            }
        }
        return temp
    }


    const makeBox=(content)=>{
        let box=[]
        for(let y=0;y<content.length;y++){
            let row=[]
            for(let x=0;x<content[0].length;x++){
                row.push(<Input key={x} value={content[y][x]} onChange={(e)=>handleInputs(y,x,e)} style={{width:'50px',height:'30px',margin:'5px'}}/>)
            }
            box.push(row)
        }
        return(
            <div id="box" className='flex-column' style={{width:'400px'}}>
                {
                    box.map((item,index)=>{
                        return(
                            <div key={index} style={{display:'flex'}}>
                                {item}
                            </div>
                        )
                    })
                }
            </div>
        )
    }
    
    return (
        <div id="block" key={index} >
            <div id='inputbox' style={{background:'RGB(250, 250, 250', borderRadius:'5px',overflowX:'scroll',border:'1px solid lightgray',padding:'10px'}}>
                {Block&&makeBox(Block.content)}
            </div>
            <div className='flex-column' style={{width:'300px',padding:'10px'}}>
                <div  className='flex-row'>
                    <div style={{fontSize:'18px',marginRight:'10px'}}>크기</div>
                    <div style={{marginRight:'10px'}}>가로 : </div>
                    <InputNumber value={Block&&Block.width} onChange={handleWidth} max={10} min={1} style={{width:'50px',marginRight:'10px'}} />
                    <div style={{marginRight:'10px'}}>세로 : </div>
                    <InputNumber value={Block&&Block.height} onChange={handleHeight} max={10} min={1} style={{width:'50px'}}/>
                </div>
                <div  className='flex-row'>
                    <div style={{fontSize:'18px',marginRight:'10px'}}>반복</div>
                    <div style={{marginRight:'10px'}}>가로 : </div>
                    <Input value={Block&&Block.horizonRep} onChange={handleHorizonRep} style={{width:'50px',marginRight:'10px'}}/>
                    <div style={{marginRight:'10px'}}>세로 : </div>
                    <Input value={Block&&Block.verticalRep} onChange={handelVerticalRep} style={{width:'50px'}}/>
                </div>

            </div>
        </div>
    )
}


export default InputBlock
