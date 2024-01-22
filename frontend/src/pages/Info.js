import React from 'react';
import UserLoginInfo from './UserLoginInfo';

function Info() {
  return (
    <div className='bg-richblack-900 min-h-[90vh] w-full py-2 mx-auto flex flex-col items-center'>
        <div className='w-full bg-white justify-center items-center'>
            <div className='flex bg-yellow-50 font-extrabold text-xl'>
                <p className='flex-[0.6]  p-2 border-2 border-black'>USERS</p>
                <p className='flex-[0.2]  p-2  border-2 border-black'>IP ADDRESS</p>
                <p className='flex-[0.2] p-2  border-2 border-black'>LOGIN (TIME)</p>
            </div>
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
            <UserLoginInfo user='user1234@gmail.com' ip='255.255.255.255' time='12:25:55' />
        </div>
    </div>
  )
}

export default Info