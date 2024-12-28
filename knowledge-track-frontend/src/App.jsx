import React from 'react';
import { Breadcrumb, Layout, Menu, theme } from 'antd';
import { Link, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Test from './pages/Test';
import DatasetList from './pages/DatasetList';
import KnowledgeData from './pages/KnowledgeData'; 
const { Header, Content, Footer } = Layout;
// const items = new Array(3).fill(null).map((_, index) => ({
//   key: String(index + 1),
//   label: `nav ${index + 1}`,
// }));
const App = () => {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();
  return (
    <Layout style={{ minHeight: '100vh', display: 'flex', flexDirection: 'column' , width: '100%' }}>
      <Header
        style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
          display: 'flex',
          alignItems: 'center'
        }}
      >
        <div className="demo-logo" />
        <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['1']}
          style={{
            flex: 1,
            minWidth: 0,
          }}
          items={[
            { key: '1', label: <Link to="/">首页</Link> },
            { key: '2', label: <Link to="/test">测试</Link> },
            { key: '3', label: <Link to="/datasetList">数据集</Link> }
          ]}
        />
      </Header>
      <Content
        style={{margin: '0 auto', paddingTop:'20px', width: '70%', backgroundColor: '#f5f5f5'}}
      >
        <Routes>
          <Route path='/' element={<Home/>}></Route>
          <Route path='/test' element={<Test/>}></Route>
          <Route path='/datasetList' element={<DatasetList/>}></Route>
          <Route path="/knowledge/:datasetId/list" element={<KnowledgeData />} />
        </Routes>
      </Content>
      <Footer
        style={{
          textAlign: 'center',
        }}
      >
        ©{new Date().getFullYear()} Created by Daily Yu
      </Footer>
    </Layout>
  );
};
export default App;