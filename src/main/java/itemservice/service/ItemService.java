package itemservice.service;


import itemservice.payload.request.SearchVo;
import itemservice.payload.response.ApiDataResponseVo;


public interface ItemService {
    ApiDataResponseVo getFruitPrice(SearchVo searchVo) throws Exception;
    ApiDataResponseVo getVegetPrice(SearchVo searchVo) throws Exception;
}
