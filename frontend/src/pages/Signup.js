import React from 'react';
import signupImg from '../Images/signup.webp';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { toast } from 'react-hot-toast';

function Signup() {
    const [signupForm,setSignupForm]=useState({
        'accountType': "Student",
        'firstName':"",
        'lastName':"",
        'email':"",
        'password':"",
        'confirmPassword':""
    });
    const [accountType,setAccountType]=useState(true);
    function handleChange(event){
        setSignupForm({...signupForm,[event.target.name]:event.target.value});
    }
    function submitForm() {  
        console.log('final form submitted');
        console.log(signupForm);
        setSignupForm({
            'accountType': "Student",
            'firstName':"",
            'lastName':"",
            'email':"",
            'password':"",
            'confirmPassword':""
        });
        setAccountType(true);
        toast.success('Signup Successfull');
    }
    function handleAccountType(event){
        console.log(event.target.value);
        if(event.target.value=='Student'){
            setAccountType(true);
            setSignupForm({...signupForm,'accountType':'Student'});
        }else{
            setAccountType(false);
            setSignupForm({...signupForm,'accountType':'Teacher'});
        }
    }
  return (
    <div className='bg-black mx-auto felx flex'>
        <div className='text-white flex flex-col my-10  gap-2 pb-3 px-2 flex-[0.5]'>
            <div className='text-richblack-25 text-4xl mx-4'>Join the Community: Create Your Account for Seamless Note Sharing!</div>
            <div className='text-richblack-300 mx-4'>Join our vibrant community effortlessly – Sign up now to embark on a seamless journey of note sharing, learning, and collaboration.</div>
            <div className='flex flex-col items-start gap-4'>
                <div className='flex bg-richblack-700 w-fit mx-4 text-lg text-white  rounded-lg p-1'>
                    <button name='accountType' onMouseOver={handleAccountType} value='Student' className={` ${accountType ? 'bg-black':''} p-1 px-3 text-white font-bold flex justify-between items-center rounded-lg`}>Student</button>
                    <button name='accountType' onMouseOver={handleAccountType} value='Teacher' className={` ${!accountType ? 'bg-black':''}  p-1 px-3 flex justify-between items-center font-bold  rounded-lg`}>Teacher</button>
                </div>
                <div className='w-full px-4 text-lg text-richblack-50 flex flex-col gap-3'>
                    <div className='flex justify-between items-center gap-3'>
                        <div className='flex flex-col w-full'>
                            <label htmlFor="">First Name<sup className='text-[#FF0000]'>*</sup></label>
                            <input onChange={handleChange} name='firstName' value={signupForm.firstName} className='bg-richblack-700 rounded-md p-1' placeholder='Enter Password' type="text" />
                        </div>
                        <div className='flex flex-col w-full'>
                            <label htmlFor="">Last Name<sup className='text-[#FF0000]'>*</sup></label>
                            <input onChange={handleChange} name='lastName' value={signupForm.lastName} className='bg-richblack-700 rounded-md p-1 px-2' placeholder='Enter first name' type="text" />
                        </div>
                    </div>
                    <div className='flex flex-col'>
                        <label htmlFor="">Email Addresss<sup className='text-[#FF0000]'>*</sup></label>
                        <input type='email' onChange={handleChange} name='email' value={signupForm.email} className='bg-richblack-700 rounded-md p-1 px-2' placeholder='Enter email address' type="text" />
                    </div>
                    <div className='flex justify-between items-center gap-3'>
                        <div className='flex flex-col w-full'>
                            <label htmlFor="">Password<sup className='text-[#FF0000]'>*</sup></label>
                            <input onChange={handleChange} name='password' value={signupForm.password} className='bg-richblack-700 rounded-md p-1' placeholder='Enter Password' type="text" />
                        </div>
                        <div className='flex flex-col w-full'>
                            <label htmlFor="">Confirm Password<sup className='text-[#FF0000]'>*</sup></label>
                            <input onChange={handleChange} name='confirmPassword' value={signupForm.confirmPassword} className='bg-richblack-700 rounded-md p-1 px-2' placeholder='Enter Password' type="text" />
                        </div>
                    </div>
                </div>
            </div>
            <Link to='/chatroom'>
                <div onClick={submitForm} className='bg-yellow-50 my-2 text-black rounded-md text-2xl text-center h-12 flex justify-center items-center mx-4'>Create Account</div>
            </Link>
        </div>
        <div className='flex justify-center items-center flex-[0.5]'>
            <img  className='h-96' src={signupImg} alt="" />
        </div>
    </div>
  )
}

export default Signup