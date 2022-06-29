package com.example.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.example.util.XlsDataSetLoader;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@SpringBootTest
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class, // このテストクラスでDIを使えるように指定
        TransactionDbUnitTestExecutionListener.class // @DatabaseSetupや@ExpectedDatabaseなどを使えるように指定
})
public class UrlRequestControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    @Test
    @DisplayName("（正常系）メールアドレスの登録がないとき")
    //@DatabaseSetup("classpath:password_rest_01.xlsx") // テスト実行前に初期データを投入
	@Transactional
    void mailSendTest_01()throws Exception{
        MvcResult mvcResult = mockMvc.perform(post("/request")
        .param("mailAddress","sample@sample.com"))
        .andExpect(view().name("/request/send"))
    			.andReturn();
    }


/*     
    @Test
    @DisplayName("（異常系）24時間以内にメール送信されている時")
    //@DatabaseSetup("classpath:password_rest_01.xlsx") // テスト実行前に初期データを投入
	@Transactional
    void mailSendTest_02()throws Exception{


    }
    @Test
    @DisplayName("（異常系）メールアドレスが既に本登録されている時")
    //@DatabaseSetup("classpath:password_rest_01.xlsx") // テスト実行前に初期データを投入
	@Transactional
    void mailSendTest_03()throws Exception{


    }
*/

    
}
