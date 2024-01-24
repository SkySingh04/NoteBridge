import React, { useState, useEffect } from 'react';
import SideChatBox from './SideChatBox';

function SideChat({onChatClick}) {
  const [contacts, setContacts] = useState([]);
  const [selectedUser, setSelectedUser] = useState(null);
  const dummyUser = {
    firstName: 'Akash',
    lastName: 'Singh',
    email: 'john_doe',
    password: '12312',
    role: 'student',
  };
  useEffect(() => {
    // Fetch contacts when the component mounts
    fetchContacts();
  }, []);

  const fetchContacts = async () => {
    try {
      // Dummy user (replace with your authentication logic)
      

      const response = await fetch('http://localhost:8080/get_contacts', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dummyUser),
      });

      if (response.ok) {
        const data = await response.json();
        console.log('data:', data);
        setContacts(data);
      } else {
        console.error('Failed to fetch contacts');
        console.error(response);
      }
    } catch (error) {
      console.error('Error during fetchContacts:', error);
    }
  };

  const handleChatClick = async (selectedContact) => {
    try {
      console.log("Dekh abhyudhay click hua")
      console.log("This is the selected contact")
      console.log(selectedContact)
      console.log("And this is what we are sending")
      console.log(dummyUser)
      

      // Fetch messages for the selected user and receiver
      const response = await fetch('http://localhost:8080/get_messages', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dummyUser),
      });

      if (response.ok) {
        const messages = await response.json();
        console.log("API call se ye wala aaya")
        console.log("If this is empty then API is not sending data properly back");
        console.log('messages:', messages);

        // Handle the fetched messages as needed (update state, display in UI, etc.)
      } else {
        console.error('Failed to fetch messages');
        console.error(response);
      }
    } catch (error) {
      console.error('Error during fetchMessages:', error);
    }
  };

  return (
    <div className='flex flex-col h-full overflow-y-scroll'>
      {contacts.map((contact, index) => (
        <SideChatBox
          key={index}
          subject={contact[0]}
          lastmessage='' // You can customize this based on your requirements
          time='' // You can customize this based on your requirements
          onClick={() => {
            setSelectedUser(contact[0]);
            handleChatClick(contact);
            if (onChatClick) {
              onChatClick(contact[0]);
            }
          }}
        />
      ))}
    </div>
  );
}

export default SideChat;
