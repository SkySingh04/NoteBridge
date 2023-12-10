import React from 'react';
import Navbar from './Navbar';
import Signin from './pages/Signin';
import Signup from './pages/Signup';
import { Route, Routes } from "react-router-dom";
import ChatRoom from './pages/ChatRoom';

function Home() {
  return (
    <div className=''>
        <Navbar />
        <div className='w-[1080px] mx-auto'>
            <Routes>
                <Route path="/" element={<ChatRoom />}  />
                <Route path="/signup" element={<Signup />}  />
                <Route path="/login" element={<Signin />}  />
            </Routes>
        </div>
    </div>
  )
}

export default Home