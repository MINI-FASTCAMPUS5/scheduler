package com.fastcampus.minischeduler.user;

import com.fastcampus.minischeduler.scheduleruser.Progress;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponse {

    @Getter
    @Setter
    public static class JoinDTO {
        private Long id;
        private String email;
        private String fullName;
        private Role role;
        private String profileImage;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.role = user.getRole();
            this.profileImage = user.getProfileImage();
        }
    }

    @Getter
    public static class DetailOutDTO{
        private Long id;
        private String email;
        private String fullName;
        private Role role;

        public DetailOutDTO(User user){
            this.id = user.getId();
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.role = user.getRole();
        }
    }

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    public static class GetUserInfoDTO {

        private String email;
        private String fullName;
        private Integer usedTicket;
        private Integer sizeOfTicket;
        private String profileImage;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        public GetUserInfoDTO(User user) {
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.sizeOfTicket = user.getSizeOfTicket();
            this.usedTicket = user.getUsedTicket();
            this.profileImage = user.getProfileImage();
            this.createdAt = user.getCreatedAt();
            this.updatedAt = user.getUpdatedAt();
        }

    }

    @Data
    @NoArgsConstructor
    public static class UserDto {
        private Long id;
        private String email;
        private String fullName;
        private int sizeOfTicket;
        private Role role;
        private String profileImage;

        public UserDto(
                Long id,
                String fullName,
                int sizeOfTicket,
                Role role,
                String profileImage
        ){
            this.id = id;
            this.fullName = fullName;
            this.sizeOfTicket = sizeOfTicket;
            this.role = role;
            this.profileImage = profileImage;
        }

        public UserDto(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.sizeOfTicket = user.getSizeOfTicket();
            this.role = user.getRole();
            this.profileImage = user.getProfileImage();
        }

        public UserDto(UserDto user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.sizeOfTicket = user.getSizeOfTicket();
            this.role = user.getRole();
            this.profileImage = user.getProfileImage();
        }
    }


    @Getter
    @Builder
    @AllArgsConstructor
    public static class GetRoleUserInfoDTO {

        private String email;
        private String fullName;
        private Integer usedTicket;
        private Integer sizeOfTicket;
        private String profileImage;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        // mypage에서 role이 user 일때. 유저가 그동안 신청했던 티켓들 리스트
        private List<GetRoleUserTicketDTO> schedulerRoleUserList;
        public GetRoleUserInfoDTO(User user) {
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.sizeOfTicket = user.getSizeOfTicket();
            this.usedTicket = user.getUsedTicket();
            this.profileImage = user.getProfileImage();
            this.createdAt = user.getCreatedAt();
            this.updatedAt = user.getUpdatedAt();
        }

    }



    public interface GetRoleUserTicketDTO{// role == user

        String getTitle();
        String getScheduleStart();
        Progress getProgress();
    }



    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetRoleAdminInfoDTO {

        private String email;
        private String fullName;
        private String profileImage;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        // 등록한 행사수
        private Integer registeredEventCount;
        // 승인 대기 인원수
        private Integer waitingCount;
        // 승인 완료 인원수
        private Integer acceptedCount;
        // 취소한 인원수
        private Integer refusedCount;
        // mypage에서 role이 admin 일때. admin이 등록한 행사 리스트
        private List<GetRoleAdminScheduleDTO> schedulerRoleAdminList;
        public GetRoleAdminInfoDTO(User user) {
            this.email = user.getEmail();
            this.fullName = user.getFullName();
            this.profileImage = user.getProfileImage();
            this.createdAt = user.getCreatedAt();
            this.updatedAt = user.getUpdatedAt();
        }

    }


    public interface GetRoleAdminScheduleDTO{// role == user

        String getTitle();
        String getDescription();
        LocalDateTime getScheduleStart();
        LocalDateTime getScheduleEnd();

    }

    public interface GetRoleAdminCountProgressDTO {

        // 승인 현황 별 count
        Integer getWaiting();
        Integer getAccepted();
        Integer getRefused();
    }

}
