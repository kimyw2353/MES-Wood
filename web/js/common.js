Date.prototype.format = function (f) {
    if (!this.valueOf()) return ' '

    var weekName = [
        '일요일',
        '월요일',
        '화요일',
        '수요일',
        '목요일',
        '금요일',
        '토요일',
    ]
    var d = this

    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function ($1) {
        switch ($1) {
            case 'yyyy':
                return d.getFullYear()
            case 'yy':
                return (d.getFullYear() % 1000).zf(2)
            case 'MM':
                return (d.getMonth() + 1).zf(2)
            case 'dd':
                return d.getDate().zf(2)
            case 'E':
                return weekName[d.getDay()]
            case 'HH':
                return d.getHours().zf(2)
            case 'hh':
                return ((h = d.getHours() % 12) ? h : 12).zf(2)
            case 'mm':
                return d.getMinutes().zf(2)
            case 'ss':
                return d.getSeconds().zf(2)
            case 'a/p':
                return d.getHours() < 12 ? '오전' : '오후'
            default:
                return $1
        }
    })
}

String.prototype.string = function (len) {
    var s = '',
        i = 0
    while (i++ < len) {
        s += this
    }
    return s
}
String.prototype.zf = function (len) {
    return '0'.string(len - this.length) + this
}
Number.prototype.zf = function (len) {
    return this.toString().zf(len)
}

Number.prototype.format = function () {
    if (this == 0) return 0

    var reg = /(^[+-]?\d+)(\d{3})/
    var n = this + ''

    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2')

    return n
}

// 문자열 타입에서 쓸 수 있도록 format() 함수 추가
String.prototype.format = function () {
    var num = parseFloat(this)
    if (isNaN(num)) return '0'

    return num.format()
}

// ajax hook
$(document).ajaxComplete(function (event, request, settings) {
    var response = request.responseJSON

    if (typeof response != 'undefined') {
        var csrf_token = $('input[name="' + response.csrf.name + '"]')
        if (csrf_token.length > 0) {
            $('input[name="' + response.csrf.name + '"]').val(response.csrf.value)
        }

        if (!response.result) {
            alert(response.message)
        }
    }
})

$(document).ready(function () {
    // // sidebar
    // var $sidebar = $('nav > ul > li');

    // $sidebar.each(function (i) {
    // 	var $item = $(this).find('ul');
    // 	if ($item.length > 0) {
    // 		if ($item.closest('li').hasClass('active')) {
    // 			$item.closest('li').find('a').attr('expanded', false);
    // 		} else {
    // 			$item.hide();
    // 		}

    // 		$item.closest('li').find('a').on('click', function (e) {
    // 			var $self = $(this).closest('li');

    // 			if ($self.hasClass('active')) {
    // 				$item.closest('li').find('ul').slideUp(200, function (e) {
    // 					$self.removeClass('active');
    // 					$item.closest('li').find('a').attr('expanded', true);
    // 				});
    // 			} else {
    // 				$item.closest('li').find('ul').slideDown(200, function (e) {
    // 					$self.addClass('active');
    // 					$item.closest('li').find('a').attr('expanded', false);
    // 				});
    // 			}
    // 		});
    // 	}
    // });

    // alert
    $('.alert .close').on('click', function (e) {
        var $self = $(this)
        $self.closest('div').slideUp(200, function (e) {
            $self.closest('div').remove()
        })
    })

    // JQuery Ui Datepicker Setting
    if (typeof $.datepicker != 'undefined') {
        $.datepicker.setDefaults({
            dateFormat: 'yy-mm-dd',
            prevText: '이전 달',
            nextText: '다음 달',
            monthNames: [
                '1월',
                '2월',
                '3월',
                '4월',
                '5월',
                '6월',
                '7월',
                '8월',
                '9월',
                '10월',
                '11월',
                '12월',
            ],
            monthNamesShort: [
                '1월',
                '2월',
                '3월',
                '4월',
                '5월',
                '6월',
                '7월',
                '8월',
                '9월',
                '10월',
                '11월',
                '12월',
            ],
            dayNames: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
            showMonthAfterYear: true,
            yearSuffix: '년',
        })
    }
})

// Daum 주소찾기
function getAddressSearch(arr, form, flag) {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if (data.userSelectedType === 'R') {
                //법정동명이 있을 경우 추가한다.
                if (data.bname !== '') {
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if (data.buildingName !== '') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
            }

            var $target_form = $("form[name='" + form + "']");
            $target_form.find("input[name='" + arr[0] + "']").val(data.zonecode);
            $target_form.find("input[name='" + arr[1] + "']").val(fullAddr);
            $target_form.find("input[name='" + arr[2] + "']").focus();

            if (typeof (flag) != 'undefined') {
                if (flag) {
                    // 주소로 상세 정보를 검색
                    geocoder.addressSearch(data.address, function (results, status) {
                        // 정상적으로 검색이 완료됐으면
                        if (status === daum.maps.services.Status.OK) {

                            var result = results[0]; //첫번째 결과의 값을 활용

                            $target_form.find('input[name="x"]').val(result.x);
                            $target_form.find('input[name="y"]').val(result.y);

                            // 해당 주소에 대한 좌표를 받아서
                            var coords = new daum.maps.LatLng(result.y, result.x);

                            // 지도를 보여준다.
                            mapContainer.style.display = "block";
                            map.relayout();

                            // 지도 중심을 변경한다.
                            map.setCenter(coords);

                            // 마커를 결과값으로 받은 위치로 옮긴다.
                            marker.setPosition(coords)
                        }
                    });
                }
            }
        }
    }).open();
}

function settingDatepicker(arr, form) {
    if (arr.length > 0) {
        var $form = $('form[name="' + form + '"]')

        if (arr.length == 1) {
            $form.find('input[name="' + arr[0] + '"]').datepicker()
        } else if (arr.length == 2) {
            $form.find('input[name="' + arr[0] + '"]').datepicker()
            $form
                .find('input[name="' + arr[0] + '"]')
                .datepicker(
                    'option',
                    'maxDate',
                    $form.find('input[name="' + arr[1] + '"]').val()
                )
            $form
                .find('input[name="' + arr[0] + '"]')
                .datepicker('option', 'onClose', function (selected) {
                    $form
                        .find('input[name="' + arr[1] + '"]')
                        .datepicker('option', 'minDate', selected)
                })
            $form.find('input[name="' + arr[1] + '"]').datepicker()
            $form
                .find('input[name="' + arr[1] + '"]')
                .datepicker(
                    'option',
                    'minDate',
                    $form.find('input[name="' + arr[0] + '"]').val()
                )
            $form
                .find('input[name="' + arr[1] + '"]')
                .datepicker('option', 'onClose', function (selected) {
                    $form
                        .find('input[name="' + arr[0] + '"]')
                        .datepicker('option', 'maxDate', selected)
                })
        }
    }
}

function option(width, height) {
    if (width == '') width = 700
    if (height == '') height = 660

    var left = (screen.availWidth - width) / 2
    var top = (screen.availHeight - height) / 2
    var specs = 'width=' + width
    specs += ',height=' + height
    specs += ',left=' + left
    specs += ',top=' + top

    return specs
}
function createManagerPopup(accountId) {
  window.open(
      '/account/ManagerCreate.do?accountId=' + accountId,
      'CreateAccountManagerPopup',
      option(500, 350) + ',toolbar=no,menubar=no,status=no,scrollbars=no,resizable=no'
  );
}
function detailManagerPopup(id){
    window.open(
        '/account/ManagerDetail.do?id=' + id,
        'DetailAccountManagerPopup',
        option(500, 350) + ',toolbar=no,menubar=no,status=no,scrollbars=no,resizable=no'
    );
}

function ListAccountPopup() {
    window.open(
        '/popup/AccountList.do',
        'popup_account_list',
        option(1100, 670) + ',toolbar=no,menubar=no,status=no,scrollbars=no,resizable=no'
    );
}