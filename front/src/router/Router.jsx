import { BrowserRouter, Route, Routes } from "react-router-dom"
import Join from "../pages/Join/Join";
import UserLogin from "../pages/Join/UserLogin";
import Profile from "../pages/Join/Profile";

const Router = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/join" element={<Join />} />
                <Route path="/user" element={<UserLogin />} />
                <Route path="/profile" element={<Profile />} />
            </Routes>
        </BrowserRouter>
    )
}

export default Router;