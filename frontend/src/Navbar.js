import React from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import Signin from './pages/Signin';

function Navbar() {
    const [btn,setbtn]=useState('login');
    function handlebtn(event){
        if(btn=='login'){
            setbtn('signup');
        }else{
            setbtn('login');
        }
    }

  return (
    <div className=' bg-[#161D29] text-richblack-200 flex w-[1080px] mx-auto justify-between py-3 px-5'>
        <div className='text-4xl font-bold'>NoteBridge</div>
        <div className='flex justify-between gap-6'>
            {btn=='signup' ? (
                <Link to='/signup'>
                <button onClick={handlebtn} name={`${btn ? 'login':'signup'}`} className=' text-lg p-2 rounded-sm border-2'>SignUp</button>
            </Link>
            ):(
                <Link to='/login'>
                <button onClick={handlebtn} name={`${btn ? 'login':'signup'}`} className=' text-lg p-2 rounded-sm border-2'>Login</button>
            </Link>
            )}
        </div>
    </div>
  )
}

export default Navbar