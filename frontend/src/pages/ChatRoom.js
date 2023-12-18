import React from 'react';
import LeftChat from './ChatRoomPages.js/LeftChat';
import RightChat from './ChatRoomPages.js/RightChat';

function ChatRoom() {
  return (
    <div className='flex bg-white'>
        <div className='flex-[0.4] border-2 h-[90vh] overflow-hidden'>
            <LeftChat />
        </div>
        <div className='flex-[0.6] h-[85vh]'>
            <RightChat />
        </div>
    </div>
  )
}

export default ChatRoom