package org.volans.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-05-19
 * @since JDK1.8
 */
public class MocTest extends BaseTest {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  /**
   * 集成Web环境测试（此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无须启动服务器）
   */
  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  /**
   * get test
   *
   * @throws Exception
   */
  @Test
  public void whenQuerySuccess() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    String res = result.getResponse().getContentAsString();
    System.out.println(res);
    Assert.assertEquals("hello world", res);
  }

  /**
   * post test
   *
   * @throws Exception
   */
  @Test

//  @Transactional // 回滚事务 ，放弃回滚 可以使用 @Rollback(false)
  public void addLearn() throws Exception {
    String json = "{\"helloWorld\":\"HAHAHAA\"}";
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/test")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .content(json.getBytes()) //传json参数
        .header("AAA", "AAA")
    )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    String res = mvcResult.getResponse().getContentAsString();
    Assert.assertEquals("HAHAHAA", res);
    assertEquals("HAHAHAA", res);
  }
}
