import React from 'react';
import loginImg from '../Images/login.webp';
import { Link } from 'react-router-dom';
import { useState } from 'react';

function Signin() {
    const [signinForm,setSigninForm]=useState({
        'accountType': "Student",
        'email':"",
        'password':""
    });
    const [accountType,setAccountType]=useState(true);
    function handleChange(event){
        setSigninForm({...signinForm,[event.target.name]:event.target.value});
    }
    function submitForm() {  
        console.log('final form submitted');
        console.log(signinForm);
        setSigninForm({
            'accountType': "Student",
            'email':"",
            'password':""
        });
        setAccountType(true);
    }
    function handleAccountType(event){
        console.log(event.target.value);
        if(event.target.value=='Student'){
            setAccountType(true);
            setSigninForm({...signinForm,'accountType':'Student'});
        }else{
            setAccountType(false);
            setSigninForm({...signinForm,'accountType':'Teacher'});
        }
    }
  return (
    <div className='bg-black mx-auto felx flex'>
        <div className='text-white flex flex-col my-10  gap-6 flex-[0.5] p-10'>
            <div className='text-richblack-25 text-4xl mx-4'>Welcome Back</div>
            <div className='text-richblack-300 mx-4'>"Unlock the power of collaboration with our note-sharing platform – where ideas converge and knowledge transcends boundaries."</div>
            <div className='flex flex-col items-start gap-4'>
                <div className='flex bg-richblack-700 w-fit mx-4 text-lg text-white  rounded-lg p-1'>
                <button name='accountType' onMouseOver={handleAccountType} value='Student' className={` ${accountType ? 'bg-black':''} p-1 px-3 text-white font-bold flex justify-between items-center rounded-lg`}>Student</button>
                    <button name='accountType' onMouseOver={handleAccountType} value='Teacher' className={` ${!accountType ? 'bg-black':''}  p-1 px-3 flex justify-between items-center font-bold  rounded-lg`}>Teacher</button>
                </div>
                <div className='w-full px-4 text-lg text-richblack-50 flex flex-col gap-3'>
                    <div className='flex flex-col'>
                        <label htmlFor="">Email Addresss<sup className='text-[#FF0000]'>*</sup></label>
                        <input onChange={handleChange} name='email' value={signinForm.email} className='bg-richblack-700 rounded-md p-1 px-2' placeholder='Enter email address' type="text" />
                    </div>
                    <div className='flex flex-col'>
                        <label htmlFor="">Password<sup className='text-[#FF0000]'>*</sup></label>
                        <input onChange={handleChange}  name='password' value={signinForm.password} className='bg-richblack-700 rounded-md p-1 px-2' placeholder='Enter Password' type="text" />
                    </div>
                </div>
            </div>
            <div onClick={submitForm} className='bg-yellow-50 my-2 text-black rounded-md text-2xl text-center h-12 flex justify-center items-center mx-4'>Sign In</div>
        </div>
        <div className='flex justify-center items-center flex-[0.5]'>
            <img  className='h-96' src={loginImg} alt="" />
        </div>
    </div>
  )
}

export default Signin