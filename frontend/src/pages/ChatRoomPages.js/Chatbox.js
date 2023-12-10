import React from 'react'

function Chatbox({name,message,time,user}) {
  return (
    <div className={`w-full flex items-center ${user? 'justify-end':''} `}>
        <div className={`bg-white w-fit m-2 rounded-md p-2`}>
            <p className='font-bold'>{name}</p>
            <div className='flex justify-center items-center'>
                <p className='flex-1'>{message}</p>
            </div>
            <p className='text-xs h-6 text-right p-1'>{time}</p>
        </div>
    </div>
  )
}

export default Chatbox