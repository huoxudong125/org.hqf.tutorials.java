import org.junit.Assert;

public class JunitDemo {

    @Test
    public void Test(){

        /*数值类型*/
//n大于1并且小于15，则测试通过
        Assert.assertThat(n, allOf(greaterThan(1),lessThan(15)));

        //n大于16或小于8，则测试通过
        Assert.assertThat(n, anyOf(greaterThan(16),lessThan(8)));

        //n为任何值，都测试通过
        Assert. assertThat(n, anything() );

        //d与3.0的差在±0.3之间，则测试通过
        Assert.assertThat(d, closeTo(3.0, 0.3) );

        //d大于等于5.0，则测试通过
        Assert.assertThat(d, greaterThanOrEqualTo (5.0) );

        //d小于等于16.0，则测试通过
        Assert.assertThat(d, lessThanOrEqualTo (16.0) );

        //        字符类型
//str的值为“tgb”，则测试通过
        Assert. assertThat(str, is("tgb") );

        //str的值不是“tgb”，则测试通过
        Assert.assertThat(str, not("tgb") );

        //str的值包含“tgb”，则测试通过
        Assert.assertThat(str, containsString("tgb") );

        //str以“tgb”结尾，则测试通过
        Assert.assertThat(str, endsWith("tgb") );

        //str以“tgb”开头，则测试通过
        Assert.assertThat(str, startsWith("tgb") );

        //str忽略大小写后，值为“tgb”，则测试通过
        Assert.assertThat(str, equalToIgnoringCase("tgb") );

        //str忽略空格后，值为“tgb”，则测试通过
        Assert.assertThat(str, equalToIgnoringWhiteSpace("tgb") );

        //n与nExpected相等，则测试通过（对象之间）
        assertThat(n, equalTo(nExpected) );

        //    collection类型
//map中包含key和value为“tgb”的键值对，则测试通过
        assertThat(map, hasEntry("tgb", "tgb") );

        //list中包含“tgb”元素，则测试通过
        assertThat(iterable, hasItem ("tgb") );

        //map中包含key为“tgb”的元素，则测试通过
        assertThat(map, hasKey ("tgb") );

        //map中包含value为“tgb”的元素，则测试通过
        assertThat(map, hasValue ("tgb") );
    }

}
