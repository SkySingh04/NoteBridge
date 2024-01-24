import React from 'react';
import Chatbox from './Chatbox';

function ChatRightMessage({ messages }) {
  console.log('Chat right message mein');
  console.log('messages:', messages);
  return (
    <div className='flex flex-col h-[70vh] overflow-y-scroll'>
      {messages.map((message, index) => (
        <Chatbox
          key={index}
          name={message[2]} // Assuming the third element in the list is the senderId
          message={message[1]} // Assuming the second element in the list is the messageText
          time={message[4]} // Assuming the fifth element in the list is the time
          user={true}
        />
      ))}
    </div>
  );
}

export default ChatRightMessage;
