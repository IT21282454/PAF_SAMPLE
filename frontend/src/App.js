import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import Home from "./Pages/Home";
import Workouts from "./Pages/Workouts";
import AdminRetrieve from "./Pages/AdminRetrieve";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/workouts" element={<Workouts />} />
                    <Route path="/admin/retrieve" element={<AdminRetrieve />} />
                </Routes>
            </BrowserRouter>
            <Toaster position="top-left" />
        </div>
    );
}

export default App;
