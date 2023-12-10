import React from 'react';
import Chatbox from './Chatbox';

function ChatRightMessage() {
  return (
    <div className='flex flex-col h-[70vh] overflow-y-scroll'>
        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>
        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>

        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>
        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>

        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>
        <Chatbox name='Person1' message='Hello! All good' time='17:56' user={true}/>
        <Chatbox name='Person2' message='Hello! All good' time='17:56' user={false}/>
    </div>
  )
}

export default ChatRightMessage