import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        //List 생성
        List<String> emptyList = new ArrayList<>();
        //비어 있는지 테스트
        assertThat(emptyList, empty());
        assertThat(emptyList.size(), is(0));

        //championList 비어 있는지 테스트 (안비어있음)
        assertThat(championList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());

        String lck2 = null;
        assertThat(lck2, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());

        String lck2 = "LCK";
        assertThat(lck2, nullValue());
    }

    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        String endString2 = "Focus";

        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString1, anyOf(startsWith(endString), endsWith(endString2)));
        assertThat(sampleString1, is(startsWith(startString)));
        assertThat(sampleString1, is(endsWith(endString2)));
        assertThat(sampleString2, is(startsWith(startString)));
        assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));

    }

    @Test
    public void 부동소수점범위테스트(){
        assertThat(3.14, closeTo(3,0.1));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        //championList에서 어떤 값이든 가져오는지
        assertThat(championList.get(2), anything());
        //anything은 null값도 통과한다.
        //index 6은 없는 값
        assertThat(championList.get(6), anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        //배열의 크기 체크, int 값을 비교
        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertFalse(championList.size() == 4);

        //객체 자체를 통으로 체크
        assertThat(championList, hasSize(5));

        List<Champion> emptyList = new ArrayList<Champion>();
        assertThat(emptyList, hasSize(0));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");

        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

        assertThat("레오나", is(supportChamp.getName()));
    }

    @Test
    public void shouldSupportChampionPositionIsBatum() {
        Champion supportChamp = new Champion("타릭", "바텀");

        assertThat("바텀", is(supportChamp.getPosition()));
        assertThat("바텀", is(equalTo(supportChamp.getPosition())));
        assertThat("바텀", equalTo(supportChamp.getPosition()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(0), hasProperty("position"));

        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        System.out.println("champion :: " + championList.get(0));

        assertThat(championList.get(4), hasProperty("name"));
        assertThat(championList.get(4), hasProperty("position"));

        assertThat(championList.get(4), hasProperty("name", equalTo("레오나")));
        System.out.println("champion :: " + championList.get(4));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(1), hasToString("애쉬"));
        assertThat(champListNames.get(2), hasToString("렉사이"));
        assertThat(champListNames.get(3), hasToString("갈리오"));
        assertThat(champListNames.get(4), hasToString("모르가느"));
        assertThat(champListNames.get(5), hasToString("블라디미르"));

        assertThat(championList.get(4).getName(), hasToString("레오나"));
    }

    @Test
    public void shouldHaveSomeFamilyName(){
        List<String> familyListNames = Arrays.asList("가영", "나영", "다영", "라영");
        assertThat(familyListNames.get(1), hasToString("나영"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");

        List<String> championNames3 = Arrays.asList("루시안", "렉사이", "모르가나", "애쉬", "갈리오", "블라디미르");
        List<String> championNames4 = Arrays.asList("루시", "렉", "모나", "애쉬", "갈오", "블라디르");
        List<String> championNames5 = Arrays.asList("렉");

        assertThat(championNames1, samePropertyValuesAs(championNames2));
        assertThat(championNames1, samePropertyValuesAs(championNames3));
        assertThat(championNames1, samePropertyValuesAs(championNames4));
        assertThat(championNames1, samePropertyValuesAs(championNames5));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        //Optional은 객체가 확정되지 않았을 때 감싸는거
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        //여기서는 탑인거가 하나밖에 없지만 첫번째꺼 가져오는거
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertFalse(champName.equals("레오나"));
        assertThat("다리우스", is(champName));
        assertThat("탑", is(champName));
    }

}