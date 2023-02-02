import About from "../pages/About";
import Blog from "../pages/Blog";
import Contact from "../pages/Contact";
import Home from "../pages/Home";

//Public routes
const publicRoutes = [
  { path: "/", component: Home },
  { path: "/about", component: About },
  { path: "/blog", component: Blog },
  { path: "/contact", component: Contact },
];

const privateRoutes = [];

export { publicRoutes, privateRoutes };
