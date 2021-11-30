import React from 'react'
import ProblemCreate2 from './index'
import { ProblemProvider } from '../../../context/problem'
function ContextWrapper() {
    return (
        <ProblemProvider>
            <ProblemCreate2></ProblemCreate2>
        </ProblemProvider>
    )
}

export default ContextWrapper
