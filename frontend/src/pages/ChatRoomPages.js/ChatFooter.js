import React from 'react';
import { IoSendSharp } from "react-icons/io5";
import { MdOutlineEmojiEmotions } from "react-icons/md";
import { ImAttachment } from "react-icons/im";

function ChatFooter() {
  return (
    <div className='flex justify-center h-10'>
        <div className='flex justify-between items-center text-3xl gap-2'>
            <MdOutlineEmojiEmotions />
            <ImAttachment />
        </div>
        <div className='flex-1 flex justify-center items-center p-2'>
            <input className='w-full rounded-md p-1 h-10' type="text" placeholder='Type a message' />
        </div>
        <div className='flex justify-center items-center text-3xl'>
            <div className='flex justify-center items-center text-3xl transition-all delay-100 hover:bg-pure-greys-200 p-2 rounded-full'>
                <IoSendSharp />
            </div>
        </div>
    </div>
  )
}

export default ChatFooter