import React from 'react';
import SideChatBox from './SideChatBox';

function SideChat() {
  return (
    <div className=' flex flex-col  h-full overflow-y-scroll'>
          <SideChatBox subject='COA' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='DSA' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='MATHS' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='OOP' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='GIT' lastmessage='Hello Everyone' time='02:23' />

          <SideChatBox subject='Web Tech Lab' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='Python' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='Unix/Shell Scripting' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='UHV' lastmessage='Hello Everyone' time='02:23' />
          <SideChatBox subject='Web3.0' lastmessage='Hello Everyone' time='02:23' />
    </div>
  )
}

export default SideChat