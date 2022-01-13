import { Route, Switch, Redirect } from "react-router-dom";
import ExcursionFormPopulated from "./pages/ExcursionFormPopulated";
import ExcursionDetailedItem from "./pages/ExcursionDetailedItem";
import LoggedInView from "./pages/LoggedInView";
import NewExcursion from "./pages/NewExcursion";
import Layout from "./components/layout/Layout";
import NotFound from "./pages/NotFound";
import Login from "./pages/Login";
import "./App.css";

function App() {
  return (
    // layout component contain MainNavigation with THU logo as a header
    <Layout>
      {/* Switch allows to display only one route at the time */}
      {/* with 'exact', the path will be matched exactly */}
      <Switch>
        <Route path="/" exact>
          <Redirect to="/login" />
        </Route>

        <Route path="/login" exact>
          <Login />
        </Route>
        <Route path="/login/excursions" exact>
          <LoggedInView />
        </Route>
        <Route path="/login/excursions/:excursionId">
          <ExcursionDetailedItem />
        </Route>
        <Route path="/new-excursion" exact>
          <NewExcursion />
        </Route>
        <Route path="/login/modify" exact>
          <ExcursionFormPopulated />
        </Route>
        {/* match all,fallback when invalid url is entered */}
        <Route path="*">
          <NotFound />
        </Route>
      </Switch>
    </Layout>
  );
}

export default App;
