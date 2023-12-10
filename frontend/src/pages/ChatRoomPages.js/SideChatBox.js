import React from 'react';
import { FaUserGroup } from "react-icons/fa6";

function SideChatBox(props) {
  return (
    <div className='flex items-center'>
        <img className='h-14 w-14' src="https://www.shutterstock.com/image-vector/vector-flat-illustration-grayscale-avatar-600nw-2264922221.jpg" alt="" />
        <div className='flex flex-col justify-between flex-1'>
            <p>{props.subject}</p>
            <div className='flex'>
                <p className='flex-1'>{props.lastmessage}</p>
                <p className='mx-2'>{props.time}</p>
            </div>
        </div>
    </div>
  )
}

export default SideChatBox