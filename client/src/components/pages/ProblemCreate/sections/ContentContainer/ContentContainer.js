import React from 'react'
import './style.scss'

function ContentContainer(props) {
    return (
        <div className="content-container">
            <div className='header'>
                <h1 className='title'>{props.title}</h1>
                <h3 className='description'>{props.subtitle}</h3>
            </div>
            {props.content}
        </div>
    )
}

export default ContentContainer
