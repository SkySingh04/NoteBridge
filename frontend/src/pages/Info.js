 import React, { useEffect, useState } from 'react';
import UserLoginInfo from './UserLoginInfo';

function Info() {
  const [userLoginInfoList, setUserLoginInfoList] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/info');
        if (!response.ok) {
          console.log(response.status);
          console.log(response.statusText)
          console.log(response)
          throw new Error('Failed to fetch data');
          
        }

        const data = await response.json();
        console.log(data);
        setUserLoginInfoList(data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []); // Empty dependency array means this effect runs once after the initial render

  return (
    <div className='bg-richblack-900 min-h-[90vh] w-full py-2 mx-auto flex flex-col items-center'>
      <div className='w-full bg-white justify-center items-center'>
        <div className='flex bg-yellow-50 font-extrabold text-xl'>
          <p className='flex-[0.6]  p-2 border-2 border-black'>USERS</p>
          <p className='flex-[0.2]  p-2  border-2 border-black'>IP ADDRESS</p>
          <p className='flex-[0.2] p-2  border-2 border-black'>LOGIN (TIME)</p>
        </div>
        {userLoginInfoList.map((userLoginInfo, index) => (
          <UserLoginInfo
            key={index}
            user={userLoginInfo[0]}
            ip={userLoginInfo[1]}
            time={userLoginInfo[2]}
          />
        ))}
      </div>
    </div>
  );
}

export default Info;
