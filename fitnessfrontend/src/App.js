import { Helmet } from "react-helmet";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { DefaultLayout } from "./components/Layout";
import { publicRoutes } from "./routes";

import shortIcon from "./assets/img/favicon.ico";
function App() {
  return (
    <>
      <Helmet>
        <title>FitMax</title>

        <link rel="icon" type="image/png" href={shortIcon} sizes="16x16" />
      </Helmet>
      <Router>
        <Routes>
          {publicRoutes.map((route, index) => {
            const Layout = DefaultLayout;
            const Page = route.component;
            return (
              <Route
                key={index}
                path={route.path}
                element={
                  <Layout>
                    <Page />
                  </Layout>
                }
              />
            );
          })}
        </Routes>
      </Router>
    </>
  );
}

export default App;
