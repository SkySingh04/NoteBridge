import React, { useState } from 'react';
import LeftChat from './ChatRoomPages.js/LeftChat';
import RightChat from './ChatRoomPages.js/RightChat';

function ChatRoom() {
  // Maintain state for messages
  const [messages, setMessages] = useState([]);

  // Handle the click on a chat in the LeftChat component
  const handleChatClick = async (selectedUser) => {
    try {
      // Fetch messages for the selected user and receiver
      const response = await fetch('http://localhost:8080/get_messages', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          user: selectedUser, // The logged-in user (replace with actual user data)
          receiver: selectedUser, // Assuming the selected user is also the receiver
        }),
      });

      if (response.ok) {
        const messagesData = await response.json();
        console.log('messages:', messagesData);

        // Update the messages state with the fetched messages
        setMessages(messagesData);
      } else {
        console.error('Failed to fetch messages');
        console.error(response);
      }
    } catch (error) {
      console.error('Error during fetchMessages:', error);
    }
  };

  return (
    <div className='flex bg-white'>
      <div className='flex-[0.4] border-2 h-[90vh] overflow-hidden'>
        {/* Pass the handleChatClick function to LeftChat */}
        <LeftChat onChatClick={handleChatClick} />
      </div>
      <div className='flex-[0.6] h-[85vh]'>
        {/* Pass the messages state to RightChat */}
        <RightChat messages={messages} />
      </div>
    </div>
  );
}

export default ChatRoom;
