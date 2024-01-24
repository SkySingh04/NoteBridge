import React, { useState } from 'react';
import LeftChat from './ChatRoomPages.js/LeftChat';
import RightChat from './ChatRoomPages.js/RightChat';

function ChatRoom() {
  // Maintain state for messages
  const [messages, setMessages] = useState([]);

  // Handle the click on a chat in the LeftChat component
  const handleChatClick = async (selectedUser) => {
    try {
      // Dummy user (replace with your authentication logic)
      const dummyUser = {
        firstName: 'Akash',
        lastName: 'Singh',
        email: 'john_doe',
        password: '12312',
        role: 'student',
      };
  
      // Include the receiverId in the JSON body
      const requestBody = {
        user: dummyUser,
        receiverId: selectedUser[0],
      };

      console.log('requestBody:', requestBody);
  
      const response = await fetch('http://localhost:8080/get_messages', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
      });
  
      if (response.ok) {
        const messages = await response.json();
        console.log('API call response:', messages);
        // Handle the fetched messages as needed
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
