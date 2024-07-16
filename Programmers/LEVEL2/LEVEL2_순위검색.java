import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
//         String[] langs = {"cpp", "java", "python"};
//         String[] kinds = {"backend", "frontend"};
//         String[] carrers = {"junior", "senior"};
//         String[] foods = {"chicken", "pizza"};

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        // System.out.println(map.get("Wd"));
        for(String i : info){
            String[] ii = i.split(" ");
            String key = ii[0] + ii[1] + ii[2] + ii[3];
            int num = Integer.parseInt(ii[4]);
            if(map.get(key) == null){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(num);
                map.put(key, a);
            } else{
                map.get(key).add(num);
                // System.out.println(map.get(key));

            }
        }

        for(String key : map.keySet()){
            map.get(key).sort(null);
        }
        ArrayList<Integer> arr = new ArrayList<>();

        for(String q : query){
            ArrayList<String> langs = new ArrayList<>();
            ArrayList<String> kinds = new ArrayList<>();
            ArrayList<String> carrers = new ArrayList<>();
            ArrayList<String> foods = new ArrayList<>();
            String[] cond = q.split(" ");
            int minScore = Integer.parseInt(cond[7]);
            if(cond[0].equals("-")){
                langs.add("java");
                langs.add("python");
                langs.add("cpp");
            } else{
                langs.add(cond[0]);
            }

            if(cond[2].equals("-")){
                kinds.add("backend");
                kinds.add("frontend");
            } else{
                kinds.add(cond[2]);
            }

            if(cond[4].equals("-")){
                carrers.add("junior");
                carrers.add("senior");
            } else{
                carrers.add(cond[4]);
            }

            if(cond[6].equals("-")){
                foods.add("pizza");
                foods.add("chicken");
            } else{
                foods.add(cond[6]);
            }
            int num = 0;
            for(String lang : langs){
                for(String kind: kinds){
                    for(String carrer: carrers){
                        for(String food : foods){
                            String key = lang + kind + carrer + food;
                            ArrayList<Integer> scoreList = map.get(key);
                            if(scoreList != null){
                                int n = scoreList.size();
                                int start = 0;
                                int end = n-1;
                                int idx = n;
                                int mid= end;
                                while(start <= end){
                                    mid = (start + end) /2;
                                    if(scoreList.get(mid) >= minScore){
                                        idx = mid;
                                        end = mid-1;
                                    }else {
                                        start = mid+1;
                                    }

                                }


                                num += scoreList.size() - idx;
                                // for(int i : scoreList){
                                //     if(i >= Integer.parseInt(cond[7])){
                                //         num++;
                                //     }
                                // }
                                // System.out.println(scoreList);
                            }

                        }
                    }
                }
            }
            arr.add(num);
            // System.out.println();
        }
        // System.out.println(arr);
        return arr.stream().mapToInt(i->i).toArray();

//         HashMap<String, HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>>> langMap = new HashMap<>();

//         for(String lang: langs){
//             langMap.put(lang, new HashMap<>());
//         }
//         for(String lang: langs){
//             HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> kindMap = langMap.get(lang);
//             for(String kind: kinds){
//                 kindMap.put(kind, new HashMap<>());
//             }
//             for(String kind: kinds){
//                 HashMap<String, HashMap<String, ArrayList<Integer>>> carrerMap = kindMap.get(kind);
//                 for(String carrer: carrers){
//                     carrerMap.put(carrer, new HashMap<>());
//                 }
//                 for(String carrer : carrers){
//                     HashMap<String, ArrayList<Integer>> foodMap = carrerMap.get(carrer);
//                     for(String food: foods){
//                         foodMap.put(food, new ArrayList<>());
//                     }
//                 }
//             }
//         }


//         for(String i : info){
//             String[] candidate = i.split(" ");
//             langMap.get(candidate[0]).get(candidate[1]).get(candidate[2]).get(candidate[3]).add(Integer.parseInt(candidate[4]));
//         }

//         for (HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> depMap : langMap.values())
//             for (HashMap<String, HashMap<String, ArrayList<Integer>>> expMap : depMap.values())
//                 for (HashMap<String, ArrayList<Integer>> foodMap : expMap.values())
//                     for (ArrayList<Integer> scoreList : foodMap.values())
//                         scoreList.sort(null);


//         int[] arr = new int[query.length];
//         int i = 0;
//         for(String q : query){
//             String[] condition = q.split(" ");
//             int minScore = Integer.parseInt(condition[7]);
//             int num = 0;
//             for(String lang: langs){
//                 if(condition[0].equals("-") || condition[0].equals(lang)){
//                     HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> kindMap = langMap.get(lang);
//                     for(String kind : kinds){
//                         if(condition[2].equals("-") || condition[2].equals(kind)){
//                             HashMap<String, HashMap<String, ArrayList<Integer>>> carrerMap = kindMap.get(kind);
//                             for(String carrer: carrers){
//                                 if(condition[4].equals("-") || condition[4].equals(carrer)){
//                                     HashMap<String, ArrayList<Integer>> foodMap = carrerMap.get(carrer);
//                                     for(String food : foods){
//                                         if(condition[6].equals("-") || condition[6].equals(food)){
//                                             ArrayList<Integer> scoreList = foodMap.get(food);
//                                             int start = 0;
//                                             int end = scoreList.size()-1;
//                                             int mid = end;
//                                             int idx = scoreList.size();
//                                             while(start <= end){
//                                                 mid = (start + end) /2;
//                                                 if(scoreList.get(mid) >= minScore){
//                                                     idx = mid;
//                                                     end = mid-1;
//                                                 }else {
//                                                     start = mid+1;
//                                                 }

//                                             }


//                                             arr[i] += scoreList.size() - idx;
//                                         }
//                                     }
//                                 }
//                             }
//                         }


//                     }
//                 }
//             }
//             i++;

//         }



        // return new int[]{0, 1};
    }
}