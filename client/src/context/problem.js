import { createContext, useState } from 'react';

const ProblemContext = createContext({
  id:"",
  title:"",
  desc:"",
  answerCode:"",
  blocks:[],
  handleTitle: () =>{},
  handleId: () =>{},
  handleDesc: () =>{},
  handleBlock: () =>{},
  handleBlocks: () =>{},

});


const ProblemProvider = ({ children }) => {

  const [title, setTitle] = useState("")
  const [id, setId] = useState("")
  const [desc, setDesc] = useState("");
  const [answerCode, setAnswerCode] = useState("")
  const [blocks, setBlocks] = useState([{content:[[""]],width:1,height:1,horizonRep:1,verticalRep:1}])

  const handleId = (e) => { setId(e.target.value); };
  const handleTitle = (e) => { setTitle(e.target.value); };
  const handleDesc = (e) => { setDesc(e.target.value); };
  const handleAnswerCode = (e) => { setAnswerCode(e.target.value); };
  
  const handleBlock = (idx, newBlock)=>{
    let temp = blocks
    temp[idx]=newBlock
    setBlocks(temp)
  }
  const handleBlocks = (newBlocks)=>{
    setBlocks(newBlocks)
  }

  return (
    <ProblemContext.Provider
      value={{
        id,title,desc,answerCode, blocks,
        handleId,handleTitle,handleDesc,handleAnswerCode,handleBlock,handleBlocks
      }}>
      {children}
    </ProblemContext.Provider>
  );
};

export { ProblemContext , ProblemProvider};