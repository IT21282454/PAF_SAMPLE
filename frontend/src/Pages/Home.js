import React from "react";
import NavigationBar from "../Components/NavigationBar";
import img1 from "../Pictures/fitness-man.jpg"

function Home() {
    return (
        <div>
            <NavigationBar />
            <img src={img1} alt="img" style={{width:"100%", objectFit: "cover"}}/>
        </div>
    );
}

export default Home;
