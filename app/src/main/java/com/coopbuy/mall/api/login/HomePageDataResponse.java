package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/7 0007 9:19
 * @content
 */
public class HomePageDataResponse implements Serializable {

    /**
     * name : App首页
     * pageKey : AppHome
     * floors : [{"name":"首页Banner","floorKey":"首页Banner","templateKey":"banner-slider-2","sort":0,"titleImage":"","bottomImage":"","floorItems":[{"name":"8.3男人节","type":4,"objectId":null,"objectData":null,"imageUrl":"/admin/images/9d14ff05-dd0f-4b38-adfa-8328552a0dce.jpg","extendData":{"link":"/GNAppActivity0803"},"sort":1},{"name":"好买严选","type":5,"objectId":35,"objectData":null,"imageUrl":"/admin/images/94f997b4-98bc-435c-8eec-d6ee512c859a.jpg","extendData":"","sort":2}]},{"name":"首页Icon","floorKey":"首页Icon","templateKey":"icons-image-1","sort":1,"titleImage":"","bottomImage":"","floorItems":[{"name":"农资农具","type":5,"objectId":4,"objectData":null,"imageUrl":"/admin/images/436536f9-6cf6-4bb4-95a6-a85b3ce8b517.png","extendData":{},"sort":1},{"name":"家电城","type":5,"objectId":5,"objectData":null,"imageUrl":"/admin/images/85309c33-bfa9-48a3-9b11-a7a824f678ce.png","extendData":{},"sort":2},{"name":"手机街","type":5,"objectId":6,"objectData":null,"imageUrl":"/admin/images/d11307ae-4d5c-4d73-81f0-4bc74e03cfff.png","extendData":{},"sort":3},{"name":"服饰馆","type":5,"objectId":7,"objectData":null,"imageUrl":"/admin/images/90fdb20e-18d2-4df9-814e-d0322613b3b6.png","extendData":{},"sort":4},{"name":"居家生活","type":5,"objectId":8,"objectData":null,"imageUrl":"/admin/images/7abea564-bb02-4829-9f66-e6a372ce1ac8.png","extendData":{},"sort":5},{"name":"箱包馆","type":5,"objectId":10,"objectData":null,"imageUrl":"/admin/images/eb1bd942-7725-4eb8-bb18-06f41051acd0.png","extendData":{},"sort":6},{"name":"汽摩城","type":5,"objectId":9,"objectData":null,"imageUrl":"/admin/images/f2dab136-7364-434e-a192-a1bfbc27280f.png","extendData":{},"sort":7},{"name":"分类","type":2,"objectId":1,"objectData":null,"imageUrl":"/admin/images/4f39a1b6-7705-42c3-aeac-64e2d484b0ab.png","extendData":{},"sort":8}]},{"name":"国美盛夏巨惠","floorKey":"国美专场","templateKey":"banner-image-1","sort":2,"titleImage":null,"bottomImage":"","floorItems":[{"name":"国美专场","type":5,"objectId":34,"objectData":null,"imageUrl":"/admin/images/b9f473dc-a217-4032-a73f-c71210819971.jpg","extendData":"","sort":2}]},{"name":"手机专场广告","floorKey":"手机专场广告","templateKey":"banner-slider-1","sort":5,"titleImage":"/admin/images/88dc1d4b-8aa2-4f31-98eb-8e47d806d943.jpg","bottomImage":"","floorItems":[{"name":"手机爆款","type":5,"objectId":6,"objectData":null,"imageUrl":"/admin/images/cacc6c5d-cd9f-47ac-9acf-f2d830f97284.png","extendData":{},"sort":0}]},{"name":"手机专场","floorKey":"手机专场","templateKey":"goods-list-1","sort":6,"titleImage":"","bottomImage":"","floorItems":[{"name":"苹果SE","type":0,"objectId":1994,"objectData":{"goodsName":"Apple iPhone SE (A1723) 16G 移动联通电信4G手机","promotionDesc":"","sellingPrice":2255,"imageUrl":"/shop/images/6f8745e7-5874-4f8d-9e32-997f08f06a16.jpg","sellingNumber":0},"imageUrl":"/shop/images/6f8745e7-5874-4f8d-9e32-997f08f06a16.jpg","extendData":{},"sort":0},{"name":"苹果6s plus","type":0,"objectId":2001,"objectData":{"goodsName":"苹果6s plus","promotionDesc":"","sellingPrice":4815,"imageUrl":"/shop/images/cf701215-8059-40c2-9d3d-fb5dcf2e9980.jpg","sellingNumber":0},"imageUrl":"/shop/images/cf701215-8059-40c2-9d3d-fb5dcf2e9980.jpg","extendData":{},"sort":1},{"name":"苹果6s","type":0,"objectId":1999,"objectData":{"goodsName":"Apple iPhone 6s (A1700) 32G 移动联通电信4G手机","promotionDesc":"","sellingPrice":3948,"imageUrl":"/shop/images/9aa18d93-d72e-48e1-a48b-9388b8197428.jpg","sellingNumber":0},"imageUrl":"/shop/images/9aa18d93-d72e-48e1-a48b-9388b8197428.jpg","extendData":{},"sort":2},{"name":"苹果7","type":0,"objectId":2007,"objectData":{"goodsName":"苹果7","promotionDesc":"","sellingPrice":4738,"imageUrl":"/shop/images/061fff8e-2990-4d01-8bc3-c126610f4bc8.jpg","sellingNumber":1},"imageUrl":"/shop/images/061fff8e-2990-4d01-8bc3-c126610f4bc8.jpg","extendData":{},"sort":3},{"name":"iPhone 7 Plus","type":0,"objectId":2008,"objectData":{"goodsName":"iPhone 7 Plus","promotionDesc":"","sellingPrice":5743,"imageUrl":"/shop/images/44b4f462-d41d-44b3-b1d3-45bb10334b32.jpg","sellingNumber":0},"imageUrl":"/shop/images/44b4f462-d41d-44b3-b1d3-45bb10334b32.jpg","extendData":{},"sort":4},{"name":" iPhone 5s","type":0,"objectId":1989,"objectData":{"goodsName":" iPhone 5s","promotionDesc":"","sellingPrice":1806,"imageUrl":"/shop/images/9ed5adce-9173-4301-a7f8-6a47e1591e8c.jpg","sellingNumber":0},"imageUrl":"/shop/images/9ed5adce-9173-4301-a7f8-6a47e1591e8c.jpg","extendData":{},"sort":5},{"name":"华为 honor/荣耀 荣耀8青春版 标配版4G全网通智能手机","type":0,"objectId":2055,"objectData":{"goodsName":"华为 honor/荣耀 荣耀8青春版 标配版4G全网通智能手机","promotionDesc":"","sellingPrice":1444,"imageUrl":"/shop/images/895eb404-75d1-4dc3-869e-d59d874472a5.jpg","sellingNumber":0},"imageUrl":"/shop/images/895eb404-75d1-4dc3-869e-d59d874472a5.jpg","extendData":{},"sort":6},{"name":"华为honor/荣耀 荣耀V9全网通","type":0,"objectId":2048,"objectData":{"goodsName":"华为honor/荣耀 荣耀V9全网通","promotionDesc":"","sellingPrice":2887,"imageUrl":"/shop/images/da2f6d7b-5311-419a-95df-b28694f0d04d.jpg","sellingNumber":0},"imageUrl":"/shop/images/da2f6d7b-5311-419a-95df-b28694f0d04d.jpg","extendData":{},"sort":7},{"name":"Huawei/华为 P9 plus智能手机","type":0,"objectId":2026,"objectData":{"goodsName":"Huawei/华为 P9 plus智能手机","promotionDesc":"","sellingPrice":2979,"imageUrl":"/shop/images/64cbccf9-6591-40d0-b746-3b08087e9b47.jpg","sellingNumber":0},"imageUrl":"/shop/images/64cbccf9-6591-40d0-b746-3b08087e9b47.jpg","extendData":{},"sort":8},{"name":"华为 Mate 9 Pro 6GB+128GB版 玫瑰金 移动联通电信4G手机 双卡双待","type":0,"objectId":2020,"objectData":{"goodsName":"华为(HUAWEI) Mate9 手机 双卡双待 全网通 6G+128G","promotionDesc":"","sellingPrice":4703,"imageUrl":"/shop/images/85da2209-7d11-4774-a1ea-2ad6dbee00e0.jpg","sellingNumber":0},"imageUrl":"/shop/images/85da2209-7d11-4774-a1ea-2ad6dbee00e0.jpg","extendData":{},"sort":9}]},{"name":"家电专场广告","floorKey":"家电专场广告","templateKey":"banner-slider-1","sort":7,"titleImage":"/admin/images/759ccb29-7d07-4de7-b5cf-a0de5154c53d.jpg","bottomImage":"","floorItems":[{"name":"TCL家电专场","type":5,"objectId":19,"objectData":null,"imageUrl":"/admin/images/a9ed20e8-0657-4a96-b9e3-f3d894d745ea.png","extendData":{},"sort":0},{"name":"九阳","type":5,"objectId":18,"objectData":null,"imageUrl":"/admin/images/9e7a7409-17d0-4981-a538-43088f0abfd7.png","extendData":{},"sort":2}]},{"name":"家电专场","floorKey":"家电专场","templateKey":"goods-list-2","sort":8,"titleImage":"","bottomImage":"","floorItems":[{"name":"TCL BCD-430WEZ50 小对开门冰箱双开门家用 电脑温控 无霜风冷","type":0,"objectId":2119,"objectData":{"goodsName":"TCL BCD-430WEZ50 小对开门冰箱双开门家用 电脑温控 无霜风冷","promotionDesc":"纤体机身 8公斤冷冻力 20个独立分区","sellingPrice":2399,"imageUrl":"/shop/images/d62135da-4ada-45e3-b504-7082790eb76c.jpg","sellingNumber":0},"imageUrl":"/shop/images/d62135da-4ada-45e3-b504-7082790eb76c.jpg","extendData":{},"sort":2},{"name":"美厨（maxcook）特惠装汤锅炒锅两件套锅具（炒锅+汤锅）电磁炉通用 MCGJ991-32炒锅带盖","type":0,"objectId":1838,"objectData":{"goodsName":"美厨（maxcook）特惠装汤锅炒锅两件套锅具（炒锅+汤锅）电磁炉通用 MCGJ991-32炒锅带盖","promotionDesc":"","sellingPrice":89,"imageUrl":"/shop/images/6239d5e1-59fb-48e9-9a7c-11caf7d42787.jpg","sellingNumber":0},"imageUrl":"/shop/images/6239d5e1-59fb-48e9-9a7c-11caf7d42787.jpg","extendData":{},"sort":3},{"name":"美厨（maxcook）菜盆调料盆味斗加厚不锈钢（和面 洗菜 拌沙拉 腌肉）","type":0,"objectId":424,"objectData":{"goodsName":"美厨（maxcook）菜盆调料盆味斗加厚不锈钢（和面 洗菜 拌沙拉 腌肉）","promotionDesc":"","sellingPrice":30.09,"imageUrl":"/shop/images/09d76143-3157-4bbc-8122-706abadb1bf2.jpg","sellingNumber":0},"imageUrl":"/shop/images/09d76143-3157-4bbc-8122-706abadb1bf2.jpg","extendData":{},"sort":4},{"name":"美厨（maxcook）炫彩系列不粘铁锅电磁炉通用","type":0,"objectId":1812,"objectData":{"goodsName":"美厨（maxcook）炫彩系列不粘铁锅电磁炉通用","promotionDesc":"","sellingPrice":59,"imageUrl":"/shop/images/743c2965-9843-485e-877b-9c331cace3f9.jpg","sellingNumber":0},"imageUrl":"/shop/images/743c2965-9843-485e-877b-9c331cace3f9.jpg","extendData":{},"sort":5},{"name":"Joyoung/九阳 JYF-50FS22电饭煲5L预约家用不锈钢电饭锅正品3-6人","type":0,"objectId":275,"objectData":{"goodsName":"Joyoung/九阳 JYF-50FS22电饭煲5L预约家用不锈钢电饭锅正品3-6人","promotionDesc":"","sellingPrice":318,"imageUrl":"/shop/images/f8979953-9bcb-488e-a703-5c6197b3de42.jpg","sellingNumber":0},"imageUrl":"/shop/images/f8979953-9bcb-488e-a703-5c6197b3de42.jpg","extendData":{},"sort":6},{"name":"美的 Midea 电饭煲 FD4019 4L 电脑版 底盘加热","type":0,"objectId":280,"objectData":{"goodsName":"美的 Midea 电饭煲 FD4019 4L 电脑版 底盘加热","promotionDesc":"电脑版 底盘加热","sellingPrice":199,"imageUrl":"/shop/images/91c1d844-f780-4f35-99c3-22c59469cc0e.jpg","sellingNumber":0},"imageUrl":"/shop/images/91c1d844-f780-4f35-99c3-22c59469cc0e.jpg","extendData":{},"sort":7},{"name":"Midea美的 电磁炉 RT2166 智能纤薄 匀火静音 触摸屏（赠炒锅+汤锅） 火力均匀 七大功","type":0,"objectId":1842,"objectData":{"goodsName":"Midea美的 电磁炉 RT2166 智能纤薄 匀火静音 触摸屏（赠炒锅+汤锅） 火力均匀 七大功","promotionDesc":"","sellingPrice":289,"imageUrl":"/shop/images/9421403b-55ae-4efc-95ec-cba0cf3fbe82.jpg","sellingNumber":0},"imageUrl":"/shop/images/3ce25c7f-b0eb-4e33-8934-c6d2f2873cbf.jpg","extendData":{},"sort":8},{"name":"美的匀火超薄触摸屏电磁炉（配送高端汤锅炒锅） RH2145","type":0,"objectId":1843,"objectData":{"goodsName":"美的匀火超薄触摸屏电磁炉（配送高端汤锅炒锅） RH2145","promotionDesc":"","sellingPrice":388,"imageUrl":"/shop/images/4ee3ae83-9cc6-4585-9805-f6d296b97f46.jpg","sellingNumber":0},"imageUrl":"/shop/images/4ee3ae83-9cc6-4585-9805-f6d296b97f46.jpg","extendData":{},"sort":9}]},{"name":"服装专场广告","floorKey":"服装专场广告","templateKey":"banner-slider-1","sort":9,"titleImage":"/admin/images/9c6dc733-6c01-4355-a6ea-939d8603261c.jpg","bottomImage":"","floorItems":[{"name":"服装专场","type":5,"objectId":7,"objectData":null,"imageUrl":"/admin/images/ea30f218-1b55-4371-af5c-3dda105953d9.png","extendData":{},"sort":0}]},{"name":"服装专场","floorKey":"服装专场","templateKey":"goods-list-1","sort":10,"titleImage":"","bottomImage":"","floorItems":[{"name":"Mexican/稻草人男士V领短袖T恤纯色打底衫夏季冰丝紧身汗衫礼盒","type":0,"objectId":1974,"objectData":{"goodsName":"Mexican/稻草人男士V领短袖T恤纯色打底衫夏季冰丝紧身汗衫礼盒","promotionDesc":"","sellingPrice":49,"imageUrl":"/shop/images/114258ea-0960-4a99-9783-88eca8b41ed0.jpg","sellingNumber":0},"imageUrl":"/shop/images/114258ea-0960-4a99-9783-88eca8b41ed0.jpg","extendData":{},"sort":0},{"name":"拼接小格子衬衣女长袖立领2017春季新品韩版宽松显瘦潮流娃娃","type":0,"objectId":1193,"objectData":{"goodsName":"拼接小格子衬衣女长袖立领2017春季新品韩版宽松显瘦潮流娃娃","promotionDesc":"","sellingPrice":59.29,"imageUrl":"/shop/images/67be0275-762d-4a3f-a143-1f90f9ce5263.jpg","sellingNumber":0},"imageUrl":"/shop/images/67be0275-762d-4a3f-a143-1f90f9ce5263.jpg","extendData":{},"sort":1},{"name":"稻草朵2017春季女装新款专柜长袖单件短款修身通勤短外套328057","type":0,"objectId":1377,"objectData":{"goodsName":"稻草朵2017春季女装新款专柜长袖单件短款修身通勤短外套328057","promotionDesc":"","sellingPrice":110,"imageUrl":"/shop/images/b40b1d17-63c0-4422-87df-13b58c80c828.jpg","sellingNumber":0},"imageUrl":"/shop/images/b40b1d17-63c0-4422-87df-13b58c80c828.jpg","extendData":{},"sort":2},{"name":"2017春装新款女装韩版时尚粉色蕾丝连衣裙裙子夏季中长款a字裙","type":0,"objectId":1795,"objectData":{"goodsName":"2017春装新款女装韩版时尚粉色蕾丝连衣裙裙子夏季中长款a字裙","promotionDesc":"","sellingPrice":84.7,"imageUrl":"/shop/images/ce1ba0e5-5609-461b-8b36-14e5cca100e1.jpg","sellingNumber":0},"imageUrl":"/shop/images/ce1ba0e5-5609-461b-8b36-14e5cca100e1.jpg","extendData":{},"sort":3},{"name":"歌诺瑞丝2017春季女装新款衣服韩版拼接收腰显瘦喇叭蕾丝连衣裙女8956","type":0,"objectId":1701,"objectData":{"goodsName":"歌诺瑞丝2017春季女装新款衣服韩版拼接收腰显瘦喇叭蕾丝连衣裙女8956","promotionDesc":"","sellingPrice":89,"imageUrl":"/shop/images/27e32747-c2e3-498d-b82e-6c792c1062ec.jpg","sellingNumber":0},"imageUrl":"/shop/images/27e32747-c2e3-498d-b82e-6c792c1062ec.jpg","extendData":{},"sort":4},{"name":"贵人鸟正品女装春秋新款跑步防风雨快干轻薄亮色面料运动茄克外套","type":0,"objectId":581,"objectData":{"goodsName":"贵人鸟正品女装春秋新款跑步防风雨快干轻薄亮色面料运动茄克外套","promotionDesc":"","sellingPrice":99,"imageUrl":"/shop/images/36cbb308-b2e7-411a-9fdf-a0128d92a86d.jpg","sellingNumber":0},"imageUrl":"/shop/images/36cbb308-b2e7-411a-9fdf-a0128d92a86d.jpg","extendData":{},"sort":14},{"name":"歌诺瑞丝2017夏季女装新款韩版波西米亚吊带背心沙滩碎花连衣裙女","type":0,"objectId":2325,"objectData":{"goodsName":"歌诺瑞丝2017夏季女装新款韩版波西米亚吊带背心沙滩碎花连衣裙女","promotionDesc":"","sellingPrice":69,"imageUrl":"/shop/images/55a3f82e-4f33-4601-be47-dda1e6dbc1ba.png","sellingNumber":0},"imageUrl":"/shop/images/55a3f82e-4f33-4601-be47-dda1e6dbc1ba.png","extendData":{},"sort":15},{"name":"歌诺瑞丝雪纺衫女短袖2017夏季女装新款碎花休闲宽松漏肩打底上衣-2252","type":0,"objectId":2323,"objectData":{"goodsName":"歌诺瑞丝雪纺衫女短袖2017夏季女装新款碎花休闲宽松漏肩打底上衣-2252","promotionDesc":"","sellingPrice":59,"imageUrl":"/shop/images/bb719e5d-c1ea-4eb2-bc78-5263e5fef1b6.jpg","sellingNumber":0},"imageUrl":"/shop/images/bb719e5d-c1ea-4eb2-bc78-5263e5fef1b6.jpg","extendData":{},"sort":16},{"name":"歌诺瑞丝雪纺衫女短袖2017夏季女装新款碎花休闲宽松打底上衣-2258","type":0,"objectId":2321,"objectData":{"goodsName":"歌诺瑞丝雪纺衫女短袖2017夏季女装新款碎花休闲宽松打底上衣-2258","promotionDesc":"","sellingPrice":59,"imageUrl":"/shop/images/80fdc8c5-1356-4dce-b690-51b598fc9911.jpg","sellingNumber":0},"imageUrl":"/shop/images/80fdc8c5-1356-4dce-b690-51b598fc9911.jpg","extendData":{},"sort":17},{"name":"歌诺瑞丝2017夏季女装新款韩版百搭短袖刺绣图案宽松显瘦T恤-1264","type":0,"objectId":2320,"objectData":{"goodsName":"歌诺瑞丝2017夏季女装新款韩版百搭短袖刺绣图案宽松显瘦T恤-1264","promotionDesc":"","sellingPrice":25.9,"imageUrl":"/shop/images/a12095ae-1c5e-40c6-bd41-44b307e36eb6.jpg","sellingNumber":0},"imageUrl":"/shop/images/a12095ae-1c5e-40c6-bd41-44b307e36eb6.jpg","extendData":{},"sort":18},{"name":"歌诺瑞丝女装新款波西米亚沙滩雪纺连衣裙夏B02","type":0,"objectId":1708,"objectData":{"goodsName":"歌诺瑞丝女装新款波西米亚沙滩雪纺连衣裙夏B02","promotionDesc":"","sellingPrice":109,"imageUrl":"/shop/images/161db2f8-a703-4bf6-85ec-f2383eca8cef.jpg","sellingNumber":0},"imageUrl":"/shop/images/161db2f8-a703-4bf6-85ec-f2383eca8cef.jpg","extendData":{},"sort":19},{"name":"倾辰2017 新款春装连衣裙长袖显瘦大码女装200斤胖MM胖妹妹连衣裙 彩色娃娃 4XL","type":0,"objectId":1734,"objectData":{"goodsName":"倾辰2017 新款春装连衣裙长袖显瘦大码女装200斤胖MM胖妹妹连衣裙 彩色娃娃 4XL","promotionDesc":"","sellingPrice":139,"imageUrl":"/shop/images/4310aa79-d066-44a8-ae22-733ef0254cec.jpg","sellingNumber":0},"imageUrl":"/shop/images/4310aa79-d066-44a8-ae22-733ef0254cec.jpg","extendData":{},"sort":20}]},{"name":"潮鞋专场广告","floorKey":"潮鞋专场广告","templateKey":"banner-slider-1","sort":11,"titleImage":"/admin/images/a464ece6-a2cc-4e9e-a678-05c685e28523.jpg","bottomImage":"","floorItems":[{"name":"品牌潮鞋","type":5,"objectId":20,"objectData":null,"imageUrl":"/admin/images/84cffbd0-5144-4fb3-98a3-ddf84679b8a3.png","extendData":{},"sort":0}]},{"name":"潮鞋专场","floorKey":"潮鞋专场","templateKey":"goods-list-1","sort":12,"titleImage":"","bottomImage":"","floorItems":[{"name":"贵人鸟正品女鞋2016春秋季新款透气休闲鞋运动鞋轻便减震防滑跑步鞋","type":0,"objectId":1528,"objectData":{"goodsName":"贵人鸟正品女鞋2016春秋季新款透气休闲鞋运动鞋轻便减震防滑跑步鞋","promotionDesc":"本店所有商品保证正品，支持专柜验货，包邮支持7天无理由退换货，请亲们放心购买！","sellingPrice":119,"imageUrl":"/shop/images/406a3d4c-1038-4d52-9ee7-ed8507ebcc0a.jpg","sellingNumber":0},"imageUrl":"/shop/images/406a3d4c-1038-4d52-9ee7-ed8507ebcc0a.jpg","extendData":{},"sort":0},{"name":"【顺丰包邮】花花公子2017春新款男士休闲皮鞋DA71035","type":0,"objectId":1830,"objectData":{"goodsName":"【顺丰包邮】花花公子2017春新款男士休闲皮鞋DA71035","promotionDesc":"春新款","sellingPrice":299,"imageUrl":"/shop/images/a1e5c415-51dd-4697-ab1e-96a1165db677.jpg","sellingNumber":0},"imageUrl":"/shop/images/a1e5c415-51dd-4697-ab1e-96a1165db677.jpg","extendData":{},"sort":2},{"name":"贵人鸟正品女鞋2016秋冬新款学生休闲鞋运动鞋耐磨透气女子慢跑步鞋","type":0,"objectId":672,"objectData":{"goodsName":"贵人鸟正品女鞋2016秋冬新款学生休闲鞋运动鞋耐磨透气女子慢跑步鞋","promotionDesc":"本店所有商品保证正品，支持专柜验货，包邮支持7天无理由退换货，请亲们放心购买！","sellingPrice":149,"imageUrl":"/shop/images/82fcadbf-6cc9-47be-8dff-2089954172ed.jpg","sellingNumber":0},"imageUrl":"/shop/images/82fcadbf-6cc9-47be-8dff-2089954172ed.jpg","extendData":{},"sort":3},{"name":"贵人鸟正品男鞋2016春秋新款透气运动鞋泡泡缓震耐磨小白鞋跑步鞋休闲鞋","type":0,"objectId":298,"objectData":{"goodsName":"贵人鸟正品男鞋2016春秋新款透气运动鞋泡泡缓震耐磨小白鞋跑步鞋休闲鞋","promotionDesc":"本店所有商品保证正品，支持专柜验货，包邮支持7天无理由退换货，请亲们放心购买！","sellingPrice":139,"imageUrl":"/shop/images/c58a4890-02ec-4bd7-b70c-e202aa163019.jpg","sellingNumber":0},"imageUrl":"/shop/images/c58a4890-02ec-4bd7-b70c-e202aa163019.jpg","extendData":{},"sort":4},{"name":"贵人鸟2017春秋新款女鞋轻便耐磨运动鞋情侣款休闲鞋小白鞋板鞋","type":0,"objectId":179,"objectData":{"goodsName":"贵人鸟2017春秋新款女鞋轻便耐磨运动鞋情侣款休闲鞋小白鞋板鞋","promotionDesc":"此款女鞋偏大一码，建议亲们拍小一码！","sellingPrice":129,"imageUrl":"/shop/images/aae7af79-0a40-42a7-9600-79c9f153346e.jpg","sellingNumber":0},"imageUrl":"/shop/images/aae7af79-0a40-42a7-9600-79c9f153346e.jpg","extendData":{},"sort":5},{"name":"贵人鸟正品女鞋2017春夏新款运动鞋休闲鞋轻便透气网面情侣阿甘鞋","type":0,"objectId":153,"objectData":{"goodsName":"贵人鸟正品女鞋2017春夏新款运动鞋休闲鞋轻便透气网面情侣阿甘鞋","promotionDesc":"本店所有商品保证正品，支持专柜验货，包邮支持7天无理由退换货，请亲们放心购买！","sellingPrice":99,"imageUrl":"/shop/images/3007096b-31c4-4d09-8fcd-73cb02bd158f.jpg","sellingNumber":0},"imageUrl":"/shop/images/2acdee9e-e983-4bc8-97f9-3ec39694db30.jpg","extendData":{},"sort":6},{"name":"夏季帆布鞋男士韩版运动青春潮流百搭板鞋男休闲鞋子男学生布鞋男","type":0,"objectId":2587,"objectData":{"goodsName":"夏季帆布鞋男士韩版运动青春潮流百搭板鞋男休闲鞋子男学生布鞋男","promotionDesc":"","sellingPrice":99,"imageUrl":"/shop/images/a12e93bb-62e1-42e0-a7b0-c36435ba413b.jpg","sellingNumber":0},"imageUrl":"/shop/images/a12e93bb-62e1-42e0-a7b0-c36435ba413b.jpg","extendData":{},"sort":8},{"name":"男鞋夏报新款男士休闲鞋潮流运动鞋青年板鞋2017新款百搭潮鞋子男","type":0,"objectId":2584,"objectData":{"goodsName":"男鞋夏报新款男士休闲鞋潮流运动鞋青年板鞋2017新款百搭潮鞋子男","promotionDesc":"","sellingPrice":99,"imageUrl":"/shop/images/6c26ceb2-390b-4047-8ca7-95982c0e649a.jpg","sellingNumber":0},"imageUrl":"/shop/images/6c26ceb2-390b-4047-8ca7-95982c0e649a.jpg","extendData":{},"sort":9},{"name":"春季新款英伦复古潮鞋 男士休闲皮鞋布洛克雕花男鞋 青年低帮板鞋","type":0,"objectId":2613,"objectData":{"goodsName":"春季新款英伦复古潮鞋 男士休闲皮鞋布洛克雕花男鞋 青年低帮板鞋","promotionDesc":"","sellingPrice":168,"imageUrl":"/shop/images/80405c5f-c0c8-40b9-a8b3-98c0df4b8a64.jpg","sellingNumber":0},"imageUrl":"/shop/images/80405c5f-c0c8-40b9-a8b3-98c0df4b8a64.jpg","extendData":{},"sort":10},{"name":"2017男鞋夏季潮流新款运动鞋男士休闲鞋韩版透气网鞋百搭跑步鞋子","type":0,"objectId":2605,"objectData":{"goodsName":"2017男鞋夏季潮流新款运动鞋男士休闲鞋韩版透气网鞋百搭跑步鞋子","promotionDesc":"","sellingPrice":128,"imageUrl":"/shop/images/e24a22e7-c5a8-44bd-ac5a-6a2fe9c30200.jpg","sellingNumber":0},"imageUrl":"/shop/images/e24a22e7-c5a8-44bd-ac5a-6a2fe9c30200.jpg","extendData":{},"sort":11},{"name":"男鞋夏季韩版透气网鞋弹力袜子鞋男运动休闲鞋潮一脚蹬懒人鞋子","type":0,"objectId":2602,"objectData":{"goodsName":"男鞋夏季韩版透气网鞋弹力袜子鞋男运动休闲鞋潮一脚蹬懒人鞋子","promotionDesc":"","sellingPrice":128,"imageUrl":"/shop/images/19b64aba-e922-4982-a5fe-00610063b221.jpg","sellingNumber":0},"imageUrl":"/shop/images/19b64aba-e922-4982-a5fe-00610063b221.jpg","extendData":{},"sort":12},{"name":"男鞋夏季凉鞋男潮2017新款露趾休闲鞋韩版户外凉鞋运动情侣沙滩鞋","type":0,"objectId":2597,"objectData":{"goodsName":"男鞋夏季凉鞋男潮2017新款露趾休闲鞋韩版户外凉鞋运动情侣沙滩鞋","promotionDesc":"","sellingPrice":109,"imageUrl":"/shop/images/0c11d40a-e468-409c-98fe-6645fd972cc1.jpg","sellingNumber":0},"imageUrl":"/shop/images/0c11d40a-e468-409c-98fe-6645fd972cc1.jpg","extendData":{},"sort":13},{"name":"2017春季男鞋新款运动休闲鞋韩版系带潮鞋学生透气跑步鞋潮流板鞋","type":0,"objectId":2702,"objectData":{"goodsName":"2017春季男鞋新款运动休闲鞋韩版系带潮鞋学生透气跑步鞋潮流板鞋","promotionDesc":"","sellingPrice":138,"imageUrl":"/shop/images/93b2b3a8-45a7-46f6-b530-0ae9e2da0e4c.jpg","sellingNumber":0},"imageUrl":"/shop/images/93b2b3a8-45a7-46f6-b530-0ae9e2da0e4c.jpg","extendData":{},"sort":15},{"name":"春季新款百搭男鞋 男士休闲鞋潮流小白鞋 乐福鞋男运动鞋板鞋子","type":0,"objectId":2687,"objectData":{"goodsName":"春季新款百搭男鞋 男士休闲鞋潮流小白鞋 乐福鞋男运动鞋板鞋子","promotionDesc":"","sellingPrice":159,"imageUrl":"/shop/images/6d9a7a60-c3b7-4fbd-8125-721a0b670775.jpg","sellingNumber":0},"imageUrl":"/shop/images/6d9a7a60-c3b7-4fbd-8125-721a0b670775.jpg","extendData":{},"sort":16},{"name":"春季男士休闲板鞋青年皮鞋男鞋英伦风反绒皮鞋子潮鞋","type":0,"objectId":1017,"objectData":{"goodsName":"春季男士休闲板鞋青年皮鞋男鞋英伦风反绒皮鞋子潮鞋","promotionDesc":"","sellingPrice":139,"imageUrl":"/shop/images/47ca9631-196d-4f03-87ac-3628f9c1f12f.png","sellingNumber":0},"imageUrl":"/shop/images/47ca9631-196d-4f03-87ac-3628f9c1f12f.png","extendData":{},"sort":18},{"name":"春季复古布洛克男鞋 潮流休闲皮鞋男士休闲鞋 英伦板鞋低帮潮鞋子","type":0,"objectId":1090,"objectData":{"goodsName":"春季复古布洛克男鞋 潮流休闲皮鞋男士休闲鞋 英伦板鞋低帮潮鞋子","promotionDesc":"","sellingPrice":159,"imageUrl":"/shop/images/d6866b13-43eb-4e78-9a24-983db00e46c3.png","sellingNumber":0},"imageUrl":"/shop/images/d6866b13-43eb-4e78-9a24-983db00e46c3.png","extendData":{},"sort":19},{"name":"2017春季新款复古男鞋 英伦真皮休闲潮鞋 青年套脚板鞋乐福鞋","type":0,"objectId":994,"objectData":{"goodsName":"2017春季新款复古男鞋 英伦真皮休闲潮鞋 青年套脚板鞋乐福鞋","promotionDesc":"","sellingPrice":158,"imageUrl":"/shop/images/75f92d3b-b10b-41ee-b762-759c1dde643b.png","sellingNumber":0},"imageUrl":"/shop/images/75f92d3b-b10b-41ee-b762-759c1dde643b.png","extendData":{},"sort":20},{"name":"男士休闲驾车鞋套脚男鞋豆豆鞋男潮流鞋子英伦单鞋","type":0,"objectId":989,"objectData":{"goodsName":"男士休闲驾车鞋套脚男鞋豆豆鞋男潮流鞋子英伦单鞋","promotionDesc":"","sellingPrice":89,"imageUrl":"/shop/images/c6c98836-adbb-4b3c-afc6-d260d9a5a736.jpg","sellingNumber":0},"imageUrl":"/shop/images/c6c98836-adbb-4b3c-afc6-d260d9a5a736.jpg","extendData":{},"sort":21},{"name":"春季新款男士休闲鞋韩版潮流商务皮鞋青年潮鞋时尚百搭低帮男鞋","type":0,"objectId":976,"objectData":{"goodsName":"春季新款男士休闲鞋韩版潮流商务皮鞋青年潮鞋时尚百搭低帮男鞋","promotionDesc":"","sellingPrice":149,"imageUrl":"/shop/images/4b4e2e41-c60e-47a9-a293-8295a6913384.jpg","sellingNumber":0},"imageUrl":"/shop/images/4b4e2e41-c60e-47a9-a293-8295a6913384.jpg","extendData":{},"sort":22},{"name":"2017新款夏季凉鞋韩版潮流男士沙滩鞋越南罗马运动休闲鞋潮鞋子","type":0,"objectId":2686,"objectData":{"goodsName":"2017新款夏季凉鞋韩版潮流男士沙滩鞋越南罗马运动休闲鞋潮鞋子","promotionDesc":"","sellingPrice":99,"imageUrl":"/shop/images/359da547-5ecf-463d-b100-8029608ec04f.jpg","sellingNumber":0},"imageUrl":"/shop/images/359da547-5ecf-463d-b100-8029608ec04f.jpg","extendData":{},"sort":23}]},{"name":"爱包包专场广告","floorKey":"爱包包专场广告","templateKey":"banner-slider-1","sort":13,"titleImage":"/admin/images/73a8ca77-bfad-41f8-8e5a-955e68f0cf01.jpg","bottomImage":"","floorItems":[{"name":"爱包包","type":5,"objectId":10,"objectData":null,"imageUrl":"/admin/images/df9f8647-9706-421e-b607-a48229f1d838.png","extendData":{},"sort":0}]},{"name":"爱包包专场","floorKey":"爱包包专场","templateKey":"goods-list-1","sort":14,"titleImage":"","bottomImage":"","floorItems":[{"name":"啄木鸟女士钱包长款真皮正品钱夹头层牛皮两折小海豚新款女皮夹5222X","type":0,"objectId":973,"objectData":{"goodsName":"啄木鸟女士钱包长款真皮正品钱夹头层牛皮两折小海豚新款女皮夹5222X","promotionDesc":"","sellingPrice":129,"imageUrl":"/shop/images/c243e6bb-f000-4260-a3e5-847298fe1da8.jpg","sellingNumber":0},"imageUrl":"/shop/images/c243e6bb-f000-4260-a3e5-847298fe1da8.jpg","extendData":{},"sort":2},{"name":"啄木鸟新款迷你蝙蝠包翅膀包女包手提包单肩斜挎包小包包潮","type":0,"objectId":953,"objectData":{"goodsName":"啄木鸟新款迷你蝙蝠包翅膀包女包手提包单肩斜挎包小包包潮","promotionDesc":"","sellingPrice":229,"imageUrl":"/shop/images/b9627eaa-bb94-4865-a6c5-0581298b5a1b.jpg","sellingNumber":0},"imageUrl":"/shop/images/b9627eaa-bb94-4865-a6c5-0581298b5a1b.jpg","extendData":{},"sort":3},{"name":"啄木鸟钱包 男士短款真皮钱包 头层牛皮横款潮钱夹男包夹新品","type":0,"objectId":292,"objectData":{"goodsName":"啄木鸟钱包 男士短款真皮钱包 头层牛皮横款潮钱夹男包夹新品","promotionDesc":"新品上市","sellingPrice":69,"imageUrl":"/shop/images/55eeff34-2cd0-4932-b7de-4296fbba0352.jpg","sellingNumber":0},"imageUrl":"/shop/images/55eeff34-2cd0-4932-b7de-4296fbba0352.jpg","extendData":{},"sort":5},{"name":"花花公子新款男包 男士单肩包斜挎包 休闲商务包2016新款 咖啡色","type":0,"objectId":715,"objectData":{"goodsName":"花花公子新款男包 男士单肩包斜挎包 休闲商务包2016新款 咖啡色","promotionDesc":"","sellingPrice":289,"imageUrl":"/shop/images/7d857fbd-e962-45ad-9531-2abb0b9b7a10.jpg","sellingNumber":0},"imageUrl":"/shop/images/7d857fbd-e962-45ad-9531-2abb0b9b7a10.jpg","extendData":{},"sort":6},{"name":"啄木鸟新款韩版时尚柳钉女包蝙蝠翅膀包包休闲手提包单肩斜挎包潮8K98M","type":0,"objectId":947,"objectData":{"goodsName":"啄木鸟新款韩版时尚柳钉女包蝙蝠翅膀包包休闲手提包单肩斜挎包潮8K98M","promotionDesc":"","sellingPrice":219,"imageUrl":"/shop/images/dd07e77c-4be2-4ffa-a6e5-ba7f7c4d8a97.jpg","sellingNumber":0},"imageUrl":"/shop/images/dd07e77c-4be2-4ffa-a6e5-ba7f7c4d8a97.jpg","extendData":{},"sort":7},{"name":"新款啄木鸟女包小方包迷你小包女士时尚单肩斜挎包 包包 潮NTNY5","type":0,"objectId":913,"objectData":{"goodsName":"新款啄木鸟女包小方包迷你小包女士时尚单肩斜挎包 包包 潮NTNY5","promotionDesc":"","sellingPrice":189,"imageUrl":"/shop/images/abe8414e-fd2c-425a-bce9-8b0e59a4a152.jpg","sellingNumber":0},"imageUrl":"/shop/images/abe8414e-fd2c-425a-bce9-8b0e59a4a152.jpg","extendData":{},"sort":8}]},{"name":"家居专场广告","floorKey":"家居专场广告","templateKey":"banner-slider-1","sort":15,"titleImage":"/admin/images/68bb19aa-abab-4d94-ad6f-bcee13f43edc.jpg","bottomImage":"","floorItems":[{"name":"家居专场","type":5,"objectId":8,"objectData":null,"imageUrl":"/admin/images/c523035a-08b0-4084-9249-079a79af0b9b.png","extendData":{},"sort":0}]},{"name":"家居专场","floorKey":"家居专场","templateKey":"goods-list-2","sort":16,"titleImage":"","bottomImage":"","floorItems":[{"name":"龙豹LB668电动车摩托车雨衣单人时尚透明大帽檐加大加厚雨披男女士 天蓝色","type":0,"objectId":1730,"objectData":{"goodsName":"龙豹LB668电动车摩托车雨衣单人时尚透明大帽檐加大加厚雨披男女士 天蓝色","promotionDesc":"护脸挡雨大帽檐 高反光设计确保行车安全","sellingPrice":29.9,"imageUrl":"/shop/images/5023cd2d-90b5-444f-8b24-ddd43228026a.jpg","sellingNumber":0},"imageUrl":"/shop/images/5023cd2d-90b5-444f-8b24-ddd43228026a.jpg","extendData":{},"sort":0},{"name":"华纳斯 优眠温馨被","type":0,"objectId":393,"objectData":{"goodsName":"华纳斯 优眠温馨被","promotionDesc":"全国包邮（黑龙江、吉林、辽宁、青海、新疆、西藏等省另加邮费20元）","sellingPrice":118,"imageUrl":"/shop/images/75724205-f77b-40d8-bfda-e39b10f28c81.jpg","sellingNumber":0},"imageUrl":"/shop/images/75724205-f77b-40d8-bfda-e39b10f28c81.jpg","extendData":{},"sort":1},{"name":"龙豹雨衣套装0016双面穿 电动摩托车雨衣分体式雨裤套装 时尚雨披双层加厚","type":0,"objectId":1719,"objectData":{"goodsName":"龙豹雨衣套装0016双面穿 电动摩托车雨衣分体式雨裤套装 时尚雨披双层加厚","promotionDesc":"【龙豹牌-LB0016-涤塔夫双面穿】送赠品鞋套","sellingPrice":68,"imageUrl":"/shop/images/68877733-21d8-4330-b605-cfd285a43ff8.jpg","sellingNumber":0},"imageUrl":"/shop/images/68877733-21d8-4330-b605-cfd285a43ff8.jpg","extendData":{},"sort":2},{"name":"华沐HM-136TG有袖带袖电动车摩托车雨衣雨披加大加长加厚 韩国时尚 天蓝加厚大号","type":0,"objectId":1688,"objectData":{"goodsName":"华沐HM-136TG有袖带袖电动车摩托车雨衣雨披加大加长加厚 韩国时尚 天蓝加厚大号","promotionDesc":"有袖时尚雨披 面料柔软不发硬","sellingPrice":33,"imageUrl":"/shop/images/e6d1ff59-a787-4abf-a378-c76d3d3daa26.jpg","sellingNumber":0},"imageUrl":"/shop/images/e6d1ff59-a787-4abf-a378-c76d3d3daa26.jpg","extendData":{},"sort":3},{"name":"美厨（maxcook）不锈钢真空保温杯MCBE-ZK500(500ML)","type":0,"objectId":1441,"objectData":{"goodsName":"美厨（maxcook）不锈钢真空保温杯MCBE-ZK500(500ML)","promotionDesc":"","sellingPrice":29.9,"imageUrl":"/shop/images/bdab4f61-603d-4234-bb59-eeb40432c95b.jpg","sellingNumber":0},"imageUrl":"/shop/images/bdab4f61-603d-4234-bb59-eeb40432c95b.jpg","extendData":{},"sort":4}]},{"name":"摩托专场广告","floorKey":"摩托专场广告","templateKey":"banner-slider-1","sort":17,"titleImage":"/admin/images/ba3a3512-a8f8-4e9c-bd09-caf232a50d32.jpg","bottomImage":"","floorItems":[{"name":"热卖摩托","type":5,"objectId":9,"objectData":null,"imageUrl":"/admin/images/0e184596-936f-4f40-b279-ce94d7990616.png","extendData":{},"sort":0}]},{"name":"摩托专场","floorKey":"摩托专场","templateKey":"goods-list-2","sort":18,"titleImage":"","bottomImage":"","floorItems":[{"name":"正招5128气囊式加大加长摩托车雨披电动车单人双人大号雨衣","type":0,"objectId":1696,"objectData":{"goodsName":"正招5128气囊式加大加长摩托车雨披电动车单人双人大号雨衣","promotionDesc":"采用高密度、高厚度涤纶布\n","sellingPrice":52,"imageUrl":"/shop/images/ed383d00-ad57-4210-baca-669a3ae5e2e3.jpg","sellingNumber":0},"imageUrl":"/shop/images/ed383d00-ad57-4210-baca-669a3ae5e2e3.jpg","extendData":{},"sort":0}]},{"name":"农机专场广告","floorKey":"农机专场广告","templateKey":"banner-slider-1","sort":19,"titleImage":"/admin/images/fb34f703-e90c-4b3e-97c7-b3ff8ce9887b.jpg","bottomImage":"","floorItems":[{"name":"农资农具","type":5,"objectId":4,"objectData":null,"imageUrl":"/admin/images/efff6b82-add7-451c-8e43-eb0bf61e206a.jpg","extendData":{},"sort":0}]},{"name":"农机专场","floorKey":"农机专场","templateKey":"goods-list-2","sort":20,"titleImage":"","bottomImage":"","floorItems":[{"name":"【补贴760元】9马力重庆鑫源汽油微耕机（加森系列） 需持身份证、购机发票自行到当地农机中心办理。","type":0,"objectId":1868,"objectData":{"goodsName":"【补贴760元】9马力重庆鑫源汽油微耕机（加森系列） 需持身份证、购机发票自行到当地农机中心办理。","promotionDesc":"采用新结构发动机,降低发动机的噪音,增加空气过滤层,降低发动机的损伤.含国家补贴（直补）补贴价格为：760元","sellingPrice":2500,"imageUrl":"/shop/images/1ccf1a7a-6858-46a1-b493-0b7bcac8bf60.jpg","sellingNumber":0},"imageUrl":"/shop/images/1ccf1a7a-6858-46a1-b493-0b7bcac8bf60.jpg","extendData":{},"sort":0},{"name":"重庆品牌：嘉木微耕机9马力；配深耕刀、防缠刀{此产品暂停国家补贴}","type":0,"objectId":1897,"objectData":{"goodsName":"重庆品牌：嘉木微耕机9马力；配深耕刀、防缠刀{此产品暂停国家补贴}","promotionDesc":"功能齐全、小巧玲珑，老人妇女都可以轻松操作；本产品为国Ⅱ柴油发动机，无国家补贴","sellingPrice":3500,"imageUrl":"/shop/images/b560a3a0-d36d-4fc6-a6c5-2745fe66f50c.jpg","sellingNumber":0},"imageUrl":"/shop/images/b560a3a0-d36d-4fc6-a6c5-2745fe66f50c.jpg","extendData":{},"sort":1},{"name":"【暂无补贴】五一牌微耕机（6马力）主要适用于丘陵山区旱地及水田作业","type":0,"objectId":1892,"objectData":{"goodsName":"【暂无补贴】五一牌微耕机（6马力）主要适用于丘陵山区旱地及水田作业","promotionDesc":"采用旋耕方式，主要适用于丘陵山区旱地及水田作业；本产品为国Ⅱ柴油发动机，无国家补贴","sellingPrice":3000,"imageUrl":"/shop/images/538a07ff-8826-4a80-b3d9-dfcb50d9d892.jpg","sellingNumber":0},"imageUrl":"/shop/images/538a07ff-8826-4a80-b3d9-dfcb50d9d892.jpg","extendData":{},"sort":2}]},{"name":"站长推荐Banner","floorKey":"站长推荐Banner","templateKey":"banner-image-1","sort":21,"titleImage":"/admin/images/133fb43e-cc1d-43a2-8875-07d83cc9d44e.png","bottomImage":"","floorItems":[{"name":"1","type":5,"objectId":21,"objectData":null,"imageUrl":"/admin/images/2173a1ae-f81b-420c-b55b-353436bf79bd.png","extendData":{"keyword":"1"},"sort":0}]},{"name":"站长推荐商品","floorKey":"MasterRecommand","templateKey":"icons-image-2","sort":51,"titleImage":"","bottomImage":"","floorItems":[{"name":"歌诺瑞丝2017春季女装新款韩版镂空刺绣衬衫+牛仔背带连衣裙女2876","type":0,"objectId":1479,"objectData":{"goodsName":"歌诺瑞丝2017春季女装新款韩版镂空刺绣衬衫+牛仔背带连衣裙女2876","promotionDesc":"","sellingPrice":129,"imageUrl":"/shop/images/3cbdbd57-d212-48a0-81d7-84f84f88ff88.jpg","sellingNumber":0},"imageUrl":"/shop/images/3cbdbd57-d212-48a0-81d7-84f84f88ff88.jpg","extendData":{},"sort":0},{"name":"贵人鸟男鞋子冬季新款韩版男士休闲鞋运动鞋男学生高帮鞋板鞋潮鞋","type":0,"objectId":1474,"objectData":{"goodsName":"贵人鸟男鞋子冬季新款韩版男士休闲鞋运动鞋男学生高帮鞋板鞋潮鞋","promotionDesc":"本店所有商品保证正品，支持专柜验货，包邮支持7天无理由退换货，请亲们放心购买！","sellingPrice":149,"imageUrl":"/shop/images/b7c05ef1-7d2b-40e4-aa9f-587e88241b72.jpg","sellingNumber":0},"imageUrl":"/shop/images/b7c05ef1-7d2b-40e4-aa9f-587e88241b72.jpg","extendData":{},"sort":1},{"name":"倾辰 2017 女装新款T恤 胖mm 加肥加大 蕾丝长袖上衣打底衫 黑色 XL","type":0,"objectId":1472,"objectData":{"goodsName":"倾辰 2017 女装新款T恤 胖mm 加肥加大 蕾丝长袖上衣打底衫 黑色 XL","promotionDesc":"","sellingPrice":128,"imageUrl":"/shop/images/be2ee9a0-2eb2-479e-8ef1-fd338d83b5b3.jpg","sellingNumber":0},"imageUrl":"/shop/images/be2ee9a0-2eb2-479e-8ef1-fd338d83b5b3.jpg","extendData":{},"sort":2}]},{"name":"热卖商品","floorKey":"50","templateKey":"goods-list-1","sort":52,"titleImage":null,"bottomImage":"","floorItems":[{"name":"久岁伴夏季新款男童短裤 儿童七分裤 中大童沙滩裤宝宝休闲中裤子","type":0,"objectId":2092,"objectData":{"goodsName":"久岁伴夏季新款男童短裤 儿童七分裤 中大童沙滩裤宝宝休闲中裤子","promotionDesc":"","sellingPrice":69,"imageUrl":"/shop/images/148620a7-90c7-4376-abd7-ffacaa3658a6.jpg","sellingNumber":0},"imageUrl":"/shop/images/148620a7-90c7-4376-abd7-ffacaa3658a6.jpg","extendData":{},"sort":1},{"name":"久岁伴新款男童T恤 莱卡棉儿童短袖T恤 中大童夏季圆领休闲T恤薄","type":0,"objectId":2084,"objectData":{"goodsName":"久岁伴新款男童T恤 莱卡棉儿童短袖T恤 中大童夏季圆领休闲T恤薄","promotionDesc":"","sellingPrice":49,"imageUrl":"/shop/images/1f5926de-24cd-4a58-a4bb-9d4b7b6debe8.jpg","sellingNumber":0},"imageUrl":"/shop/images/1f5926de-24cd-4a58-a4bb-9d4b7b6debe8.jpg","extendData":{},"sort":3},{"name":"久岁伴新款女童睡衣 莱卡棉 春夏家居服薄 中大童宝宝短袖T恤套装","type":0,"objectId":2074,"objectData":{"goodsName":"久岁伴新款女童睡衣 莱卡棉 春夏家居服薄 中大童宝宝短袖T恤套装","promotionDesc":"","sellingPrice":89,"imageUrl":"/shop/images/09d7f855-2b6c-4f1a-9fbc-06cd36868b37.jpg","sellingNumber":0},"imageUrl":"/shop/images/09d7f855-2b6c-4f1a-9fbc-06cd36868b37.jpg","extendData":{},"sort":4},{"name":"久岁伴男童内裤 夏莱卡棉 中大童儿童平角内裤 男孩宝宝内裤薄款","type":0,"objectId":2121,"objectData":{"goodsName":"久岁伴男童内裤 夏莱卡棉 中大童儿童平角内裤 男孩宝宝内裤薄款","promotionDesc":"","sellingPrice":22.9,"imageUrl":"/shop/images/39c222ab-f229-444f-81ad-d98653c1c44c.jpg","sellingNumber":0},"imageUrl":"/shop/images/39c222ab-f229-444f-81ad-d98653c1c44c.jpg","extendData":{},"sort":5},{"name":"久岁伴新款儿童短袖T恤 女童夏季圆领T恤 中大童时尚外穿T恤薄","type":0,"objectId":2118,"objectData":{"goodsName":"久岁伴新款儿童短袖T恤 女童夏季圆领T恤 中大童时尚外穿T恤薄","promotionDesc":"","sellingPrice":49,"imageUrl":"/shop/images/40aaba52-cf49-47e9-bd48-62c51f3c4b7d.jpg","sellingNumber":0},"imageUrl":"/shop/images/40aaba52-cf49-47e9-bd48-62c51f3c4b7d.jpg","extendData":{},"sort":6},{"name":"TCL BCD-228TEWF1 三门冰箱 三门式家用风冷无霜电冰箱电脑温控","type":0,"objectId":2116,"objectData":{"goodsName":"TCL BCD-228TEWF1 三门冰箱 三门式家用风冷无霜电冰箱电脑温控","promotionDesc":"15kg冷动力 四大技术 节能一步到位","sellingPrice":1999,"imageUrl":"/shop/images/549ff9ad-03ea-4af3-9c8c-103e6dd72677.jpg","sellingNumber":0},"imageUrl":"/shop/images/549ff9ad-03ea-4af3-9c8c-103e6dd72677.jpg","extendData":{},"sort":7},{"name":"稻草朵2017春季新款女装套头长袖专柜中长款修身毛针织衫322293","type":0,"objectId":25,"objectData":{"goodsName":"稻草朵2017春季新款女装套头长袖专柜中长款修身毛针织衫322293","promotionDesc":"","sellingPrice":79,"imageUrl":"/shop/images/a0131d1d-07a5-490f-a7d5-9968ae7073c1.jpg","sellingNumber":0},"imageUrl":"/shop/images/a0131d1d-07a5-490f-a7d5-9968ae7073c1.jpg","extendData":{},"sort":8},{"name":"传奇保罗T恤男短袖夏季潮流男T恤修身男士t恤","type":0,"objectId":24,"objectData":{"goodsName":"传奇保罗T恤男短袖夏季潮流男T恤修身男士t恤","promotionDesc":"","sellingPrice":138,"imageUrl":"/shop/images/ad72ed95-c05c-4a75-b560-222768424da3.jpg","sellingNumber":0},"imageUrl":"/shop/images/ad72ed95-c05c-4a75-b560-222768424da3.jpg","extendData":{},"sort":9},{"name":"倾辰 雪纺衫2017 新款学院风修身蝴蝶结雪纺长袖衬衫","type":0,"objectId":32,"objectData":{"goodsName":"倾辰 雪纺衫2017 新款学院风修身蝴蝶结雪纺长袖衬衫","promotionDesc":"","sellingPrice":89,"imageUrl":"/shop/images/5ff81a11-aff0-4b99-99c6-6d0a70b6ee2b.jpg","sellingNumber":0},"imageUrl":"/shop/images/5ff81a11-aff0-4b99-99c6-6d0a70b6ee2b.jpg","extendData":{},"sort":10},{"name":"【蓝菲女包】2017新款时尚潮流新款女包单肩斜跨手提包子母包包 买一送五","type":0,"objectId":40,"objectData":{"goodsName":"【蓝菲女包】2017新款时尚潮流新款女包单肩斜跨手提包子母包包 买一送五","promotionDesc":"","sellingPrice":99,"imageUrl":"/shop/images/fb9170d6-396e-42c8-94ab-c5b05b201a8a.jpg","sellingNumber":0},"imageUrl":"/shop/images/fb9170d6-396e-42c8-94ab-c5b05b201a8a.jpg","extendData":{},"sort":11},{"name":"歌诺瑞丝2017春季女装新款韩版圆领宽松显瘦印花字母T恤女9935","type":0,"objectId":37,"objectData":{"goodsName":"歌诺瑞丝2017春季女装新款韩版圆领宽松显瘦印花字母T恤女9935","promotionDesc":"春装焕新","sellingPrice":69.9,"imageUrl":"/shop/images/597590bb-bf7d-405a-940d-8cfb2595ba99.jpg","sellingNumber":0},"imageUrl":"/shop/images/597590bb-bf7d-405a-940d-8cfb2595ba99.jpg","extendData":{},"sort":12},{"name":" 衬衫打底衫2017时尚甜美百搭韩版学院棉绣花大码休闲纯色衬衣 浅蓝色 3XL","type":0,"objectId":44,"objectData":{"goodsName":" 衬衫打底衫2017时尚甜美百搭韩版学院棉绣花大码休闲纯色衬衣 浅蓝色 3XL","promotionDesc":"","sellingPrice":109,"imageUrl":"/shop/images/c3f3f232-b2bd-49d6-8b84-d65625684be3.jpg","sellingNumber":0},"imageUrl":"/shop/images/c3f3f232-b2bd-49d6-8b84-d65625684be3.jpg","extendData":{},"sort":13},{"name":"传奇保罗男士衬衫2017春季新款青年长袖条纹时尚修身衬衫男 ","type":0,"objectId":42,"objectData":{"goodsName":"传奇保罗男士衬衫2017春季新款青年长袖条纹时尚修身衬衫男 ","promotionDesc":"","sellingPrice":178,"imageUrl":"/shop/images/91d1a0cb-5b2d-45c3-9f9b-3c7ea5d42fef.jpg","sellingNumber":0},"imageUrl":"/shop/images/91d1a0cb-5b2d-45c3-9f9b-3c7ea5d42fef.jpg","extendData":{},"sort":14}]}]
     * id : 1
     */

    private String name;
    private String pageKey;
    private int id;
    private List<FloorsBean> floors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FloorsBean> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorsBean> floors) {
        this.floors = floors;
    }

    public static class FloorsBean {
        /**
         * name : 首页Banner
         * floorKey : 首页Banner
         * templateKey : banner-slider-2
         * sort : 0
         * titleImage :
         * bottomImage :
         * floorItems : [{"name":"8.3男人节","type":4,"objectId":null,"objectData":null,"imageUrl":"/admin/images/9d14ff05-dd0f-4b38-adfa-8328552a0dce.jpg","extendData":{"link":"/GNAppActivity0803"},"sort":1},{"name":"好买严选","type":5,"objectId":35,"objectData":null,"imageUrl":"/admin/images/94f997b4-98bc-435c-8eec-d6ee512c859a.jpg","extendData":"","sort":2}]
         */

        private String name;
        private String floorKey;
        private String templateKey;
        private int sort;
        private String titleImage;
        private String bottomImage;
        private List<FloorItemsBean> floorItems;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFloorKey() {
            return floorKey;
        }

        public void setFloorKey(String floorKey) {
            this.floorKey = floorKey;
        }

        public String getTemplateKey() {
            return templateKey;
        }

        public void setTemplateKey(String templateKey) {
            this.templateKey = templateKey;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(String titleImage) {
            this.titleImage = titleImage;
        }

        public String getBottomImage() {
            return bottomImage;
        }

        public void setBottomImage(String bottomImage) {
            this.bottomImage = bottomImage;
        }

        public List<FloorItemsBean> getFloorItems() {
            return floorItems;
        }

        public void setFloorItems(List<FloorItemsBean> floorItems) {
            this.floorItems = floorItems;
        }

        public static class FloorItemsBean {
            /**
             * name : 8.3男人节
             * type : 4
             * objectId : null
             * objectData : null
             * imageUrl : /admin/images/9d14ff05-dd0f-4b38-adfa-8328552a0dce.jpg
             * extendData : {"link":"/GNAppActivity0803"}
             * sort : 1
             */

            private String name;
            private int type;
            private Object objectId;
            private Object objectData;
            private String imageUrl;
            private ExtendDataBean extendData;
            private int sort;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getObjectId() {
                return objectId;
            }

            public void setObjectId(Object objectId) {
                this.objectId = objectId;
            }

            public Object getObjectData() {
                return objectData;
            }

            public void setObjectData(Object objectData) {
                this.objectData = objectData;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public ExtendDataBean getExtendData() {
                return extendData;
            }

            public void setExtendData(ExtendDataBean extendData) {
                this.extendData = extendData;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public static class ExtendDataBean {
                /**
                 * link : /GNAppActivity0803
                 */

                private String link;

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }
            }
        }
    }
}
