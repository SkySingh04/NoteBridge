import React, { useState } from 'react';
import { FaSearch } from 'react-icons/fa';
import { MdFilterList } from 'react-icons/md';
import { MdMessage } from 'react-icons/md';
import { SlOptionsVertical } from 'react-icons/sl';
import { MdDonutLarge } from 'react-icons/md';
import SideChat from './SideChat';

function LeftChat({ onChatClick }) {
  // Maintain state for the selected user
  const [selectedUser, setSelectedUser] = useState(null);

  // Handle the click on a chat
  const handleChatClick = (user) => {
    setSelectedUser(user);
    // Call the callback function passed as prop to notify the parent component
    if (onChatClick) {
      onChatClick(user);
    }
  };
  return (
    <div className='flex flex-col'>
        <div className='h-20 flex justify-between items-center'>
            <img className='h-16 w-16' src="https://www.shutterstock.com/image-vector/vector-flat-illustration-grayscale-avatar-600nw-2264922221.jpg" alt="" />
            <div className='h-16 mx-2 flex justify-between items-center gap-2'>
              <div className='text-2xl px-2'> <MdMessage /></div>
              <div className='text-2xl'><SlOptionsVertical /></div>
              <div className='text-2xl'><MdDonutLarge /></div>
            </div>
        </div>
        <div className='flex items-center text-2xl'>
            <div className='bg-pure-greys-25 flex flex-1 p-2 justify-center items-center'>
              <div className='flex justify-center items-center h-fit'><FaSearch /></div>
              <input className='flex flex-1 bg-pure-greys-25 px-2' type="text" placeholder='Search or start new chat' />
            </div>
            <div className='m-2 text-4xl'><MdFilterList /></div>
        </div>
        <div className='h-[70vh]'>
          <SideChat  onChatClick={handleChatClick}/>
        </div>
    </div>
  )
}

export default LeftChat