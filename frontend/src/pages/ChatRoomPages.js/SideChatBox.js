import React from 'react';
import { FaUserGroup } from "react-icons/fa6";

function SideChatBox({ subject, lastmessage, time, onClick }) {
  return (
    <div className='cursor-pointer' onClick={onClick}>
        <img className='h-14 w-14' src="https://www.shutterstock.com/image-vector/vector-flat-illustration-grayscale-avatar-600nw-2264922221.jpg" alt="" />
        <div className='flex flex-col justify-between flex-1'>
            <p>{subject}</p>
            <div className='flex'>
                <p className='flex-1'>{lastmessage}</p>
                <p className='mx-2'>{time}</p>
            </div>
        </div>
    </div>
  )
}

export default SideChatBox