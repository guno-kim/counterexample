import React from 'react'
import { ProblemProvider } from '../context/problem'
export default function ProblemWrapper(SpecificComponent) {
    return (
        <ProblemProvider>
            <SpecificComponent></SpecificComponent>
        </ProblemProvider>
    )
}

