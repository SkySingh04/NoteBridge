import React from 'react';
import { SlOptionsVertical } from "react-icons/sl";
import { FaSearch } from "react-icons/fa";
import { ImAttachment } from "react-icons/im";
import ChatFooter from './ChatFooter';
import ChatRightMessage from './ChatRightMessage';

function RightChat({messages}) {
  console.log('messages:', messages);
  return (
    <div className='border-2 border-richblack-900 flex flex-col'>
        <div className='h-20 flex justify-between items-center '>
            <img className='h-16 w-16' src="https://www.shutterstock.com/image-vector/vector-flat-illustration-grayscale-avatar-600nw-2264922221.jpg" alt="" />
            <div className='h-16 mx-2 flex justify-between items-center gap-5'>
              <div className='text-2xl'><ImAttachment /></div>
              <div className='text-2xl'><FaSearch /></div>
              <div className='text-2xl'><SlOptionsVertical /></div>
            </div>
        </div>
        <div className='flex-1 bg-richblack-900'>
        {/* Pass the messages state to ChatRightMessage */}
        <ChatRightMessage messages={messages} />
      </div>
      <div className='bg-pure-greys-25 p-2'>
        <ChatFooter />
      </div>
    </div>
  )
}

export default RightChat