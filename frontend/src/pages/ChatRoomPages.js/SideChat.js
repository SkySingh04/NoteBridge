import React, { useState, useEffect } from 'react';
import SideChatBox from './SideChatBox';

function SideChat() {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    // Fetch contacts when the component mounts
    fetchContacts();
  }, []);

  const fetchContacts = async () => {
    try {
      const dummyUser = {
        firstName: 'John',
        lastName: 'Doe',
        email: 'john.doe@example.com',
        password: 'password123',
        role: 'user',
      };

      const response = await fetch('http://localhost:8080/get_contacts', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dummyUser),
      });

      if (response.ok) {
        const data = await response.json();
        setContacts(data);
      } else {
        console.error('Failed to fetch contacts');
      }
    } catch (error) {
      console.error('Error during fetchContacts:', error);
    }
  };

  return (
    <div className='flex flex-col h-full overflow-y-scroll'>
      {contacts.map((contact, index) => (
        <SideChatBox
          key={index}
          subject={contact[0]} // Assuming the first element in the list is the subject (email)
          lastmessage='' // You can customize this based on your requirements
          time='' // You can customize this based on your requirements
        />
      ))}
    </div>
  );
}

export default SideChat;
