
// 导入axios实例
import request from '../utils/request'
const apiMap = {
  list: list
}
export default apiMap


function list(params) {
    return request({
      url: '/dataset/list',
      method: 'get',
      params: params
    })
}

