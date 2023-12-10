import React from 'react';
import TimelineImage from '../Images/TimelineImage.png';
import { Link } from 'react-router-dom';

function LandingPage() {
  return (
    <div className='flex bg-richblack-900 text-richblack-100 h-[90vh]'>
        <div className='flex-[0.5] flex flex-col justify-center items-center p-10 gap-10'>
            <p className='text-5xlcd font-extrabold text-white'>Empower Learning with NoteBridge
            <div className='w-full mt-8'>
                <div className='h-1 w-20 bg-white'></div>
            </div></p>
            <p>Unleash the Potential of Collaborative Note Sharing for Educators
                Description: "Unlock the potential of collaborative teaching with NoteBridge – the ultimate platform where educators seamlessly share notes, ideas, and resources, fostering a dynamic and enriching learning experience for students."</p>
            <div className='flex gap-4 w-full'>
                <Link to='/signup'>
                    <button className='bg-yellow-50 text-black text-2xl font-semibold p-2 rounded-md'>Signup</button>
                </Link>
                <Link to={'/login'}>
                    <button className='bg-[#161D29] text-white text-2xl font-bold p-2 rounded-md'>Login</button>
                </Link>
            </div>
        </div>
        <div className='flex-[0.5] p-10 flex justify-center items-center'>
            <img src={TimelineImage} alt="" />
        </div>
    </div>
  )
}

export default LandingPage