// TODO: To remove
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';

import 'react-tabs/style/react-tabs.css';

const TabsList = () => (
    <Tabs>
        <TabList>
            <Tab>Contracts</Tab>
            <Tab>Tariffs</Tab>
        </TabList>

        <TabPanel>
            <h2>Contracts</h2>
        </TabPanel>
        <TabPanel>
            <h2>Tariffs</h2>
        </TabPanel>
    </Tabs>
)