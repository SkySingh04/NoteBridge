import React from 'react';
import { FaRegUserCircle } from "react-icons/fa";

function UserLoginInfo(props) {
  return (
    <div className='flex text-white bg-richblack-700 text-xl '>
        <p className='flex-[0.6] p-2  border-2 border-black flex gap-2 items-center' ><span className='text-black flex justify-center h-full w-[40px] items-center'><img src="https://thumbs.dreamstime.com/b/user-profile-grey-icon-web-avatar-employee-symbol-user-profile-grey-icon-web-avatar-employee-symbol-sign-illustration-design-191067342.jpg" alt="" /></span>{props.user}</p>
        <p className='flex-[0.2] p-2  border-2 border-black'>{props.ip}</p>
        <p className='flex-[0.2] p-2  border-2 border-black'>{props.time}</p>
    </div>
  )
}

export default UserLoginInfo