import React, { useState } from 'react';
import { IoSendSharp } from "react-icons/io5";
import { MdOutlineEmojiEmotions } from "react-icons/md";
import { ImAttachment } from "react-icons/im";

function ChatFooter({ receiverId, onMessageSent }) {
  const [message, setMessage] = useState('');

  const sendMessage = async () => {
    try {
      // Dummy user (replace with your authentication logic)
      const dummyUser = {
        firstName: 'Akash',
        lastName: 'Singh',
        email: 'john_doe',
        password: '12312',
        role: 'student',
      };

      const requestBody = {
        user: dummyUser,
        receiverId,
        message,
        link: '', // Add the link if needed
      };
      console.log('Chat footer mein');
      console.log('requestBody:', requestBody);

      const response = await fetch('http://localhost:8080/send_message', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
      });

      if (response.ok) {
        const result = response;
        console.log('Message sent successfully:', result);
        window.location.reload()

        // Notify the parent component that the message has been sent
        if (onMessageSent) {
          onMessageSent();
        }

        // Optionally, you can clear the message input
        setMessage('');
      } else {
        console.error('Failed to send message');
        console.error(response);
      }
    } catch (error) {
      console.error('Error during sendMessage:', error);
    }
  };

  return (
    <div className='flex justify-center h-10'>
      <div className='flex justify-between items-center text-3xl gap-2'>
        <MdOutlineEmojiEmotions />
        <ImAttachment />
      </div>
      <div className='flex-1 flex justify-center items-center p-2'>
        <input
          className='w-full rounded-md p-1 h-10'
          type="text"
          placeholder='Type a message'
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />
      </div>
      <div
        className='flex justify-center items-center text-3xl transition-all delay-100 hover:bg-pure-greys-200 p-2 rounded-full cursor-pointer'
        onClick={sendMessage}
      >
        <IoSendSharp />
      </div>
    </div>
  );
}

export default ChatFooter;
