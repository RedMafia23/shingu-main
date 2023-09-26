package com.shingu.shingubackend.api;

import org.dbunit.Assertion;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.csv.CsvURLDataSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import javax.sql.DataSource;

import java.net.URL;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductApiTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private DataSource dataSource;

        @ParameterizedTest
        @MethodSource("findAllTestProvider")
        public void testFindAll(String expectedBody, String dbPath) throws Exception {
                IDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource);
                URL givenUrl = this.getClass()
                                .getResource("/products/products/default/given/");
                databaseTester.setDataSet(new CsvURLDataSet(givenUrl));
                databaseTester.onSetup();

                mockMvc.perform(
                                MockMvcRequestBuilders.get("/products")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .accept(MediaType.APPLICATION_JSON_UTF8))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect((result) -> JSONAssert.assertEquals(
                                                expectedBody,
                                                result.getResponse().getContentAsString(),
                                                false));

                var actualDataSet = databaseTester.getConnection().createDataSet();
                var actualTestTable = actualDataSet.getTable("products");

                URL expectedUrl = this.getClass().getResource("/products/products/default/expected/");

                var expectedDataSet = new CsvURLDataSet(expectedUrl);
                var expectedTestTable = expectedDataSet.getTable("products");
                Assertion.assertEquals(expectedTestTable, actualTestTable);
        }

        private static Stream<Arguments> findAllTestProvider() {
                return Stream.of(
                                Arguments.arguments(
                                                """
                                                                [
                                                                        {
                                                                                "id": 1,
                                                                                "name": "掛け布団",
                                                                                "description": "ふかふか",
                                                                                "image": "/images/1.jpg",
                                                                                "category": "掛け布団",
                                                                                "price": 9999
                                                                        },
                                                                        {
                                                                                "id": 2,
                                                                                "name": "掛け布団　花柄",
                                                                                "description": "ふっかふっか",
                                                                                "image": "/images/2.jpg",
                                                                                "category": "掛け布団",
                                                                                "price": 88888
                                                                        },
                                                                        {
                                                                                "id": 3,
                                                                                "name": "掛け布団　白",
                                                                                "description": "ふっかふっか　もふもふ",
                                                                                "image": "/images/3.jpg",
                                                                                "category": "掛け布団",
                                                                                "price": 7777
                                                                        },
                                                                        {
                                                                                "id": 4,
                                                                                "name": "掛け布団　ストライプ",
                                                                                "description": "ふっかふっか　もふもふ　心地よい肌ざわり",
                                                                                "image": "/images/4.jpg",
                                                                                "category": "掛け布団",
                                                                                "price": 6666
                                                                        },
                                                                        {
                                                                                "id": 5,
                                                                                "name": "枕",
                                                                                "description": "特殊な構造で横向き寝を促進し、耳や顔への圧迫を軽減します。いびき対策にも。",
                                                                                "image": "/images/5.jpg",
                                                                                "category": "枕",
                                                                                "price": 5555
                                                                        },
                                                                        {
                                                                                "id": 6,
                                                                                "name": "高さ調整　枕",
                                                                                "description": "オーダー感覚！計10ヶ所でお好みの高さにピッタリ調整！丸洗いができ、通気性と耐久性に優れたパイプ素材で快適。",
                                                                                "image": "/images/6.jpg",
                                                                                "category": "枕",
                                                                                "price": 4990
                                                                        },
                                                                        {
                                                                                "id": 7,
                                                                                "name": "マシュマロ　枕",
                                                                                "description": "極細繊維の中わたと伸縮生地で、マシュマロタッチのやさしい感触。",
                                                                                "image": "/images/7.jpg",
                                                                                "category": "枕",
                                                                                "price": 999
                                                                        },
                                                                        {
                                                                                "id": 8,
                                                                                "name": "布団カバー　ピンク",
                                                                                "description": "ピンク花柄。",
                                                                                "image": "/images/8.jpg",
                                                                                "category": "布団カバー",
                                                                                "price": 7800
                                                                        },
                                                                        {
                                                                                "id": 9,
                                                                                "name": "布団カバー　cool",
                                                                                "description": "冷たさ長持ち。抗菌防臭加工・制菌加工付きでいつでも清潔。",
                                                                                "image": "/images/9.jpg",
                                                                                "category": "布団カバー",
                                                                                "price": 7777
                                                                        }
                                                                        ]

                                                                                """,
                                                "default"));
        }
}
